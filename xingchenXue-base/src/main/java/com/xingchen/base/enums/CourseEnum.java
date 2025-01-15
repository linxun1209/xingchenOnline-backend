package com.xingchen.base.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author: 35238
 * 功能: 课程的枚举类
 * 时间: 2024-04-04 17:02
 */
@Getter
public enum CourseEnum implements IEnum<String> {

    AUDIT_STATUS_NO("202001","未通过审核"),
    AUDIT_STATUS_YES("202004","已通过审核"),
    AUDIT_SUBMIT_NO("202002","未提交审核"),
    AUDIT_SUBMIT_YES("202003","已提交审核"),

    PUBLISH_NO("203001","未发布"),
    PUBLISH_YES("203002","已发布"),
    PUBLISH_DOWN("203003","下线"),

    FEE_NO("201000","免费"),
    FEE_YES("201001","收费"),

    MINIO_AUDIT_PENDING("002002","未审核"),
    MINIO_AUDIT_NO("002001","审核未通过"),
    MINIO_AUDIT_YES("002003","审核通过"),

    MINIO_FILE_YES("1","展示"),
    MINIO_FILE_NO("0","不展示"),
    MINIO_FILE_LOCK("-1","文件锁住"),

    MINIO_TYPE_IMG("001001","图片"),
    MINIO_TYPE_VIDEO("001002","视频"),
    MINIO_TYPE_OTHER("001003","其它"),

    ;

    private String code;
    private String desc;

    CourseEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    @Override
    @JsonValue
    public String getValue() { //数据库交互的话，用code。@JsonValue表示返回给前端的时候，用code
        return code;
    }
}