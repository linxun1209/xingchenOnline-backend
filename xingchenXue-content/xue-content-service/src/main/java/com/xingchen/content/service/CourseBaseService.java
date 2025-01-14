package com.xingchen.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingchen.base.model.PageParams;
import com.xingchen.base.model.PageResult;
import com.xingchen.domain.dto.AddCourseDto;
import com.xingchen.domain.dto.CourseBaseInfoDto;
import com.xingchen.domain.dto.EditCourseDto;
import com.xingchen.domain.dto.QueryCourseParamsDto;
import com.xingchen.domain.entity.CourseBase;

public interface CourseBaseService extends IService<CourseBase> {

    /**
     * 分页查询
     * @param pageParams 分页参数
     * @param dto 查询条件
     */
    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto dto);


    /**
     * 新增课程
     * @param companyId 公司id
     * @param dto 新增数据
     * @return
     */
    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto dto);

    /**
     * 根据课程id查询课程信息
     * @param courseId 课程id
     * @return 课程详细信息
     */
    CourseBaseInfoDto getCourseBaseInfo(Long courseId);

    /**
     * 修改课程
     * @param companyId 机构id
     * @param editCourseDto 修改课程信息
     * @return 课程详细信息
     */
    CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto);

}