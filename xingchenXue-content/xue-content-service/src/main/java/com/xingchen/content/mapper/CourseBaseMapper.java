package com.xingchen.content.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingchen.domain.entity.CourseBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 课程基本信息(CourseBase)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-30 22:36:12
 */
@Mapper  //声明这是一个MyBatis Mapper，MyBatis Plus会自动��找Mapper接口的实现类，并生成代理类。
// 以下是MyBatis Plus 5.x 新加入的 Page 功能的示例
public interface CourseBaseMapper extends BaseMapper<CourseBase> {
    Page<CourseBase> coursePage(Page<CourseBase> page, @Param(Constants.WRAPPER) Wrapper<CourseBase> queryWrapper);

}