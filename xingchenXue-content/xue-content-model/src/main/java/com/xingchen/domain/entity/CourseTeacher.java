package com.xingchen.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 课程-教师关系表(CourseTeacher)表实体类
 *
 * @author makejava
 * @since 2024-03-27 22:09:51
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course_teacher")
public class CourseTeacher  {

    //主键@TableId
    private Long id;

    //课程标识
    @NotEmpty(message = "课程id不能为空")
    private String courseId;

    //教师标识
    @NotEmpty(message = "教师姓名不能为空")
    private String teacherName;

    //教师职位
    @NotEmpty(message = "教师职位不能为空")
    private String position;

    //教师简介
    @NotEmpty(message = "教师简介不能为空")
    private String introduction;

    //照片
    private String photograph;

    //创建时间
    private Date createDate;
}