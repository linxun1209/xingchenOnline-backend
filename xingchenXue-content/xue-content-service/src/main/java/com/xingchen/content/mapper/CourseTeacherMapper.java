package com.xingchen.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingchen.domain.entity.CourseTeacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程-教师关系表(CourseTeacher)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-12 20:55:30
 */
@Mapper
public interface CourseTeacherMapper extends BaseMapper<CourseTeacher> {

}