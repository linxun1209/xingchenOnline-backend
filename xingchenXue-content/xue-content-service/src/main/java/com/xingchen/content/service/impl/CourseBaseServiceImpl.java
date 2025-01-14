package com.xingchen.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingchen.base.enums.CourseEnum;
import com.xingchen.base.exception.SystemException;
import com.xingchen.base.model.PageParams;
import com.xingchen.base.model.PageResult;
import com.xingchen.content.mapper.CourseBaseMapper;
import com.xingchen.content.mapper.CourseCategoryMapper;
import com.xingchen.content.mapper.CourseMarketMapper;
import com.xingchen.content.service.CourseBaseService;
import com.xingchen.domain.dto.AddCourseDto;
import com.xingchen.domain.dto.CourseBaseInfoDto;
import com.xingchen.domain.dto.EditCourseDto;
import com.xingchen.domain.dto.QueryCourseParamsDto;
import com.xingchen.domain.entity.CourseBase;
import com.xingchen.domain.entity.CourseCategory;
import com.xingchen.domain.entity.CourseMarket;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 课程基本信息(CourseBase)表服务实现类
 *
 * @author makejava
 * @since 2024-03-30 22:35:08
 */
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements CourseBaseService {

    @Autowired
    CourseBaseMapper baseMapper;

    @Autowired
    CourseMarketMapper marketMapper;

    @Autowired
    CourseCategoryMapper categoryMapper;

    //----------------------------------------课程查询------------------------------------------

    @Override
    public PageResult<CourseBase> queryCourseBaseList (PageParams pageParams, QueryCourseParamsDto dto) {
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.like(StringUtils.isNotEmpty(dto.getCourseName()),CourseBase::getName,dto.getCourseName());

        //按课程发布状态查询，StringUtils.isNotEmpty()表示该字段可传可不传，非常灵活，不传就不根据这个字段查
        queryWrapper.eq(StringUtils.isNotEmpty(dto.getAuditStatus()), CourseBase::getAuditStatus,dto.getAuditStatus());
        queryWrapper.eq(StringUtils.isNotEmpty(dto.getPublishStatus()), CourseBase::getStatus,dto.getPublishStatus());

        //分页
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> pageResult = baseMapper.coursePage(page, queryWrapper);

        //分页里面的每一条具体数据
        List<CourseBase> items = pageResult.getRecords();
        //分页里面的总记录数
        long total = pageResult.getTotal();

        //封装数据
        PageResult<CourseBase> courseBasePageResult = new PageResult<>(items,total,pageParams.getPageNo(), pageParams.getPageSize());
        return courseBasePageResult;
    }

    //----------------------------------------课程新增------------------------------------------

    @Transactional
    @Override
    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto dto){

        //【插入课程信息】
        CourseBase courseBaseNew = new CourseBase();
        //把dto的字段值，放到courseBaseNew对象里面。注意字段一致才能放进去
        //如果dto某个字段的字段值为空，而courseBaseNew对象的这个字段值不为空，那么dto优先级大，也就是最终courseBaseNew对象的这个字段值为空
        BeanUtils.copyProperties(dto,courseBaseNew);
        courseBaseNew.setCompanyId(companyId);
        courseBaseNew.setCreateDate(new Date());
        //用户新增的课程，审核状态默认是未提交审核
        courseBaseNew.setAuditStatus(CourseEnum.AUDIT_SUBMIT_NO);
        //用户新增的课程，发布状态默认是未发布
        courseBaseNew.setStatus(CourseEnum.PUBLISH_NO);
        //插入数据库
        int insert = baseMapper.insert(courseBaseNew);
        if(insert<=0){
            throw new RuntimeException("添加课程失败");
        }

        //【插入营销信息】
        CourseMarket courseMarketNew = new CourseMarket(dto);
        BeanUtils.copyProperties(dto,courseMarketNew);
        //上面课程新增成功之后，就用课程id了，直接拿
        Long courseId = courseBaseNew.getId();
        courseMarketNew.setId(courseId);
        //保存营销信息
        saveCourseMarket(courseMarketNew);

        //【查询刚刚插入的这条课程信息+营销信息，把这两个信息拼接好返回给前端】
        CourseBaseInfoDto courseBaseInfo = getCourseBaseInfo(courseId, courseMarketNew);

        return courseBaseInfo;
    }

    //查询课程信息+营销信息
    public CourseBaseInfoDto getCourseBaseInfo(long courseId, CourseMarket courseMarket){

        //查询课程信息
        CourseBase courseBase = baseMapper.selectById(courseId);
        if(courseBase==null){
            return null;
        }

        //组装在一起
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();
        BeanUtils.copyProperties(courseBase,courseBaseInfoDto);
        if(courseMarket!=null){
            BeanUtils.copyProperties(courseMarket,courseBaseInfoDto);
        }

        //分类的具体名称我们也返回给前端
        courseBaseInfoDto.setMt(categoryMapper.selectById(courseBase.getMt()).getName());//大分类
        courseBaseInfoDto.setSt(categoryMapper.selectById(courseBase.getSt()).getName());//小分类

        return courseBaseInfoDto;

    }

    //如果营销信息存在，就更新旧的营销信息，不存在则添加
    private int saveCourseMarket(CourseMarket courseMarketNew){

        System.out.println(courseMarketNew);

        //用户填写课程时，勾选了收费，但是没有填写收费的有效价格(例如没填、填了负数、填了0)
        if(courseMarketNew.getCharge().equals(CourseEnum.FEE_YES)){
            if(courseMarketNew.getPrice() ==null || courseMarketNew.getPrice().floatValue()<=0){
                SystemException.cast("课程的价格不能为空并且必须大于0");
            }
        }

        //从数据库查询营销信息，看是否能查到，如果能查到就表示存在，那么存在则更新，不存在则添加
        Long id = courseMarketNew.getId();//主键
        CourseMarket courseMarket = marketMapper.selectById(id);
        if(courseMarket == null){
            //添加
            int insert = marketMapper.insert(courseMarketNew);
            return insert;
        }else{
            BeanUtils.copyProperties(courseMarketNew,courseMarket);
            courseMarket.setId(courseMarketNew.getId());
            //更新
            int i = marketMapper.updateById(courseMarket);
            return i;
        }
    }


    //---------------------------------根据课程id查询课程信息--------------------------------------

    @Override
    public CourseBaseInfoDto getCourseBaseInfo(Long courseId) {
        //查询课程信息
        CourseBase courseBase = baseMapper.selectById(courseId);
        if(courseBase == null){
            return null;
        }
        //查询营销信息
        CourseMarket courseMarket = marketMapper.selectById(courseId);
        //要返回的对象
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();
        BeanUtils.copyProperties(courseBase,courseBaseInfoDto);
        if(courseMarket != null){
            BeanUtils.copyProperties(courseMarket,courseBaseInfoDto);
        }
        //查询分类名称
        CourseCategory courseCategoryBySt = categoryMapper.selectById(courseBase.getSt());
        courseBaseInfoDto.setSt(courseCategoryBySt.getName());
        CourseCategory courseCategoryByMt = categoryMapper.selectById(courseBase.getMt());
        courseBaseInfoDto.setMt(courseCategoryByMt.getName());

        return courseBaseInfoDto;
    }


    //----------------------------------------课程修改------------------------------------------

    @Override
    public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto) {

        //拿到课程id
        Long courseId = editCourseDto.getId();
        //查询课程信息
        CourseBase courseBase = baseMapper.selectById(courseId);
        if(courseBase == null){
            SystemException.cast("课程不存在");
        }

        //数据合法性校验
        if(!companyId.equals(courseBase.getCompanyId())){
            SystemException.cast("本机构只能修改本机构的课程");
        }

        //封装数据
        BeanUtils.copyProperties(editCourseDto,courseBase);
        //修改时间
        courseBase.setChangeDate(new Date());

        //更新数据库
        int i = baseMapper.updateById(courseBase);
        if(i<=0){
            SystemException.cast("修改课程失败");
        }

        //更新营销表的信息
        CourseMarket courseMarketNew = new CourseMarket(editCourseDto);
        BeanUtils.copyProperties(editCourseDto,courseMarketNew);
        courseMarketNew.setId(courseId);
        saveCourseMarket(courseMarketNew);

        //返回修改后的课程信息
        CourseBaseInfoDto courseBaseInfo = getCourseBaseInfo(courseId);
        return courseBaseInfo;
    }

}