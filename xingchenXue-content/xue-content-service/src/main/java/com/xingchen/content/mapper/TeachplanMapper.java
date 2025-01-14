package com.xingchen.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingchen.domain.dto.TeachplanDto;
import com.xingchen.domain.entity.Teachplan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程计划(Teachplan)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-07 20:46:47
 */
@Mapper
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    /**
     * 查询某课程的课程计划，组成树型结构
     * @param courseId
     * @return
     */
    List<TeachplanDto> selectTreeNodes(long courseId);



    /**
     * 课程计划的新增|修改 确定排序字段的值
     * @param parentId
     * @param courseId
     * @return
     */
    Integer selectOrderCount(@Param("parentId") Long parentId, @Param("courseId") Long courseId);


}