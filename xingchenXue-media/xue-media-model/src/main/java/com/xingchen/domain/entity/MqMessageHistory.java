package com.xingchen.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * (MqMessageHistory)表实体类
 *
 * @author makejava
 * @since 2024-04-15 22:16:53
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("mq_message_history")
public class MqMessageHistory  {
    //消息id@TableId
    private Long id;

    //消息类型代码
    private String messageType;
    //关联业务信息
    private String businessKey1;
    //关联业务信息
    private String businessKey2;
    //关联业务信息
    private String businessKey3;
    //消息队列主机
    private String mqHost;
    //消息队列端口
    private Integer mqPort;
    //消息队列虚拟主机
    private String mqVirtualhost;
    //队列名称
    private String mqQueue;
    //通知次数
    private String informNum;
    //处理状态，0:初始，1:成功，2:失败
    private String state;
    //回复失败时间
    private Date returnfailureDate;
    //回复成功时间
    private Date returnsuccessDate;
    //回复失败内容
    private String returnfailureMsg;
    //最近通知时间
    private Date informDate;
    
    private String stageState1;
    
    private String stageState2;
    
    private String stageState3;
    
    private String stageState4;
}