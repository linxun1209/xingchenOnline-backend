package com.xingchen.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (MediaProcess)表实体类
 *
 * @author makejava
 * @since 2024-04-15 22:15:29
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("media_process")
public class MediaProcess  {
    @TableId
    private Long id;

    //文件标识
    private String fileId;
    //文件名称
    private String filename;
    //存储桶
    private String bucket;
    //存储路径
    private String filePath;
    //状态,1:未处理，2：处理成功  3处理失败
    private String status;
    //上传时间
    private Date createDate;
    //完成时间
    private Date finishDate;
    //失败次数
    private String failCount;
    //媒资文件访问地址
    private String url;
    //失败原因
    private String errormsg;
}