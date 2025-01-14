package com.xingchen.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 35238
 * 功能: 编辑课程
 * 时间: 2024-04-06 20:38
 */
@Data
public class EditCourseDto extends AddCourseDto {

    @ApiModelProperty(value = "课程id", required = true)
    private Long id;

}