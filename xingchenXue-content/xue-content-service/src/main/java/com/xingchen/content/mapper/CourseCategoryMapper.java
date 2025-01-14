package com.xingchen.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingchen.domain.dto.CourseCategoryTreeDto;
import com.xingchen.domain.entity.CourseCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程分类(CourseCategory)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-02 21:21:28
 */
@Mapper
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {

    /**
     * 课程分类的查询
     * @param id
     * @return
     */
    List<CourseCategoryTreeDto> selectTreeNodes(@Param("id") String id);
}