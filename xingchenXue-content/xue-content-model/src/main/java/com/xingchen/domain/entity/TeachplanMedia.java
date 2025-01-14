package com.xingchen.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * (TeachplanMedia)表实体类
 *
 * @author makejava
 * @since 2024-03-27 22:10:59
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teachplan_media")
public class TeachplanMedia  {

    //主键
    @TableId
    private Long id;

    //媒资文件id
    @TableField("media_id")
    private String mediaId;

    //课程计划标识
    @TableField("teachplan_id")
    private Long teachplanId;

    //课程标识
    @TableField("course_id")
    private Long courseId;

    //媒资文件原始名称
    @TableField("media_fileName")
    private String mediaFilename;

    @TableField("create_date")
    private Date createDate;

    //创建人
    @TableField("create_people")
    private String createPeople;

    //修改人
    @TableField("change_people")
    private String changePeople;
}