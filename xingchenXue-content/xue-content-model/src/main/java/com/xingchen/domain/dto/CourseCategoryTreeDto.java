package com.xingchen.domain.dto;

import com.xingchen.domain.entity.CourseCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 35238
 * 功能: 课程分类的查询
 * 时间: 2024-04-02 20:54
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {

    List<CourseCategoryTreeDto> childrenTreeNodes;
}