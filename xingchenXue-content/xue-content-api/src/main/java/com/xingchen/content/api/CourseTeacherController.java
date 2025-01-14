package com.xingchen.content.api;


import com.xingchen.content.service.CourseTeacherService;
import com.xingchen.domain.entity.CourseTeacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 35238
 * 功能: 课程计划-教师
 * 时间: 2024-04-12 20:45
 */
@Api(value = "课程教师管理",tags = "课程教师管理")
@RestController
public class CourseTeacherController {

    @Autowired
    private CourseTeacherService courseTeacherService;

    /**
     * 课程教师查询接口
     * @param courseId 课程id
     * @return
     */
    @ApiOperation("课程教师查询接口")
    @GetMapping("courseTeacher/list/{courseId}")
    public List<CourseTeacher> findAllcourseTeacher(@PathVariable Long courseId){
        List<CourseTeacher> teacherList = courseTeacherService.findAllcourseTeacher(courseId);
        return teacherList;
    }

    /**
     * 课程教师添加、修改接口
     * @param courseTeacher 教师基本信息
     * @return CourseTeacher 教师基本信息
     */
    @ApiOperation("课程教师添加、修改接口")
    @PostMapping("/courseTeacher")
    public CourseTeacher saveCourseTeacher(@RequestBody @Validated CourseTeacher courseTeacher){
        return courseTeacherService.saveCourseTeacher(courseTeacher);
    }


    /**
     * 课程教师删除
     * @param courseId   课程id
     * @param courseTeacherId 教师id
     * @return
     */
    @ApiOperation("课程教师删除接口")
    @DeleteMapping("/courseTeacher/course/{courseId}/{courseTeacherId}")
    public void deleteCourseTeacher(@PathVariable Long courseId,@PathVariable Long courseTeacherId){
        courseTeacherService.deleteCourseTeacher(courseId,courseTeacherId);
    }
}