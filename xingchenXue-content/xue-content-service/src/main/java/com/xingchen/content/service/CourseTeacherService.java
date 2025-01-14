package com.xingchen.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingchen.domain.entity.CourseTeacher;

import java.util.List;

/**
 * 课程-教师关系表(CourseTeacher)表服务接口
 *
 * @author makejava
 * @since 2024-04-12 20:55:31
 */
public interface CourseTeacherService extends IService<CourseTeacher> {

    /**
     * 课程教师查询接口
     * @param courseId 课程id
     * @return
     */
    List<CourseTeacher> findAllcourseTeacher(Long courseId);

    /**
     * 课程教师添加、修改接口
     * @param courseTeacher 教师基本信息
     * @return CourseTeacher 教师基本信息
     */
    CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher);

    /**
     * 课程教师删除接口
     * @param courseId   课程id
     * @param courseTeacherId 教师id
     * @return
     */
    void deleteCourseTeacher(Long courseId, Long courseTeacherId);
}