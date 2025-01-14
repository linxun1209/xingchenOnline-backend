package com.xingchen.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingchen.domain.dto.SaveTeachplanDto;
import com.xingchen.domain.dto.TeachplanDto;
import com.xingchen.domain.entity.Teachplan;

import java.util.List;

/**
 * 课程计划(Teachplan)表服务接口
 *
 * @author makejava
 * @since 2024-04-07 20:46:48
 */
public interface TeachplanService extends IService<Teachplan> {

    /**
     * 根据课程id查询课程计划
     * @param courseId 课程计划
     * @return
     */
    List<TeachplanDto> findTeachplanTree(Long courseId);


    /**
     * 课程计划的新增|修改
     * @param saveTeachplanDto
     */
    void saveTeachplan(SaveTeachplanDto saveTeachplanDto);


    /**
     * 删除课程计划
     * @param teachplanId 课程计划id
     */
    void deleteTeachplan(Long teachplanId);


    /**
     * 课程计划层级 下移
     * @param teachplanId 课程计划id
     */
    void movedownTeachplan(Long teachplanId);

    /**
     * 课程计划层级 上移
     * @param teachplanId 课程计划id
     */
    void moveupTeachplan(Long teachplanId);
}