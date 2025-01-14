package com.xingchen.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingchen.domain.dto.CourseCategoryTreeDto;
import com.xingchen.domain.entity.CourseCategory;

import java.util.List;

/**
 * 课程分类(CourseCategory)表服务接口
 *
 * @author makejava
 * @since 2024-04-02 21:21:29
 */
public interface CourseCategoryService extends IService<CourseCategory> {
    /**
     * 课程分类树形结构查询
     * @param id
     * @return
     */
    List<CourseCategoryTreeDto> queryTreeNodes(String id);
}