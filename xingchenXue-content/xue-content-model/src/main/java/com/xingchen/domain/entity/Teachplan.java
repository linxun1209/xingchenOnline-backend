package com.xingchen.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 课程计划(Teachplan)表实体类
 *
 * @author makejava
 * @since 2024-03-27 22:10:47
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teachplan")
public class Teachplan  {

    @TableId
    private Long id;

    //课程计划名称
    @TableField("pname")
    private String pname;

    //课程计划父级Id
    @TableField("parentid")
    private Long parentid;

    //层级，分为1、2、3级
    @TableField("grade")
    private Integer grade;

    //课程类型:1视频、2文档
    @TableField("media_type")
    private String mediaType;

    //开始直播时间
    @TableField("start_time")
    private Date startTime;

    //直播结束时间
    @TableField("end_time")
    private Date endTime;

    //章节及课程时介绍
    @TableField("description")
    private String description;

    //时长，单位时:分:秒
    @TableField("timelength")
    private String timelength;

    //排序字段
    @TableField("orderby")
    private Integer orderby;

    //课程标识
    @TableField("course_id")
    private Long courseId;

    //课程发布标识
    @TableField("course_pub_id")
    private Long coursePubId;

    //状态（1正常  0删除）
    @TableField("status")
    private Integer status;

    //是否支持试学或预览（试看）
    @TableField("is_preview")
    private String isPreview;

    //创建时间
    @TableField("create_date")
    private Date createDate;

    //修改时间
    @TableField("change_date")
    private Date changeDate;
}