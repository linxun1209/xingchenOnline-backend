package com.xingchen.content.api;

import com.xingchen.content.service.CourseCategoryService;
import com.xingchen.domain.dto.CourseCategoryTreeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 35238
 * 功能: 课程分类的查询
 * 时间: 2024-04-02 21:04
 */

@Api(value = "课程分类管理",tags = "课程分类管理")
@RestController
public class CourseCategoryController {


    @Autowired
    CourseCategoryService courseCategoryService;

    @ApiOperation("查询课程分类")
    @GetMapping("/course-category/tree-nodes")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        return courseCategoryService.queryTreeNodes("1");
    }
}