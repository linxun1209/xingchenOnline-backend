package com.xingchen.content.api;

import com.xingchen.base.model.PageParams;
import com.xingchen.base.model.PageResult;
import com.xingchen.content.service.CourseBaseService;
import com.xingchen.domain.dto.AddCourseDto;
import com.xingchen.domain.dto.CourseBaseInfoDto;
import com.xingchen.domain.dto.EditCourseDto;
import com.xingchen.domain.dto.QueryCourseParamsDto;
import com.xingchen.domain.entity.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 35238
 * 功能: 课程信息编辑接口
 * 时间: 2024-03-28 21:10
 */
@Api(value = "课程信息编辑",tags = "课程信息编辑")
@RestController
public class CourseBaseInfoController {

    @Autowired
    CourseBaseService courseBaseService;


    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto dto){
        PageResult<CourseBase> pageResult = courseBaseService.queryCourseBaseList(pageParams, dto);
        return pageResult;
    }


    @ApiOperation("新增课程")
    @PostMapping("/course")
    //@Validated注解的作用是开启参数校验，这样AddCourseDto类的@NotEmpty、@Size注解才会生效
    public CourseBaseInfoDto createCourseBase(@Validated @RequestBody AddCourseDto addCourseDto){
        //机构id，先硬编码，后续写机构端的时候会回来解决这个硬编码
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseBase = courseBaseService.createCourseBase(companyId, addCourseDto);
        return courseBase;
    }

    @ApiOperation("根据课程id查询接口")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId){
        CourseBaseInfoDto courseBaseInfo = courseBaseService.getCourseBaseInfo(courseId);
        return courseBaseInfo;
    }

    @ApiOperation("修改课程")
    @PutMapping("/course")
    public CourseBaseInfoDto modifyCourseBase(@RequestBody @Validated EditCourseDto editCourseDto){
        //机构id，先硬编码，后续写机构端的时候会回来解决这个硬编码
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseBaseInfoDto = courseBaseService.updateCourseBase(companyId, editCourseDto);
        return courseBaseInfoDto;
    }





}