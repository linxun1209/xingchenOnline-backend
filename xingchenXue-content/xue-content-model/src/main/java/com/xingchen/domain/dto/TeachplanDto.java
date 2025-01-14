package com.xingchen.domain.dto;


import com.xingchen.domain.entity.Teachplan;
import com.xingchen.domain.entity.TeachplanMedia;
import lombok.Data;

import java.util.List;

/**
 * @author: 35238
 * 功能: 课程计划树型结构
 * 时间: 2024-04-07 20:50
 */
@Data
public class TeachplanDto extends Teachplan {

    //课程计划的媒资信息
    TeachplanMedia teachplanMedia;

    //子结点，也就是小章节list
    List<TeachplanDto> teachPlanTreeNodes;

}