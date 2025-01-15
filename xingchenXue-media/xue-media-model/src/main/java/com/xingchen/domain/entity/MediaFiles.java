package com.xingchen.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 媒资信息(MediaFiles)表实体类
 *
 * @author makejava
 * @since 2024-04-15 22:14:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("media_files")
public class MediaFiles  {
    //文件id,md5值@TableId
    //文件id,md5值
    @TableId(type= IdType.INPUT)//修改为插入id字段，不然MyBatisPlus在插入的时候会忽略id字段，导致这个字段没数据从而报错
    private String id; //md5是数字+英文，用Long类型会报错，改为String

    //机构ID
    private Long companyId;
    //机构名称
    private String companyName;
    //文件名称
    private String filename;
    //文件类型（图片、文档，视频）
    private String fileType;
    //标签
    private String tags;
    //存储目录
    private String bucket;
    //存储路径
    private String filePath;
    //文件id
    private String fileId;
    //媒资文件访问地址
    private String url;
    //上传人
    private String username;
    //上传时间
    private Date createDate;
    //修改时间
    private Date changeDate;
    //状态,1:正常，0:不展示
    private String status;
    //备注
    private String remark;
    //审核状态
    private String auditStatus;
    //审核意见
    private String auditMind;
    //文件大小
    private Long fileSize;
}