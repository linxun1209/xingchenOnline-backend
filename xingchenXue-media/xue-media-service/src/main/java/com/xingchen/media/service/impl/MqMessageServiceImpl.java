package com.xingchen.media.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingchen.media.mapper.MqMessageMapper;
import com.xingchen.media.service.MqMessageService;
import com.xingchen.domain.entity.MqMessage;
import org.springframework.stereotype.Service;

/**
 * (MqMessage)表服务实现类
 *
 * @author makejava
 * @since 2024-04-15 22:19:36
 */
@Service
public class MqMessageServiceImpl extends ServiceImpl<MqMessageMapper, MqMessage> implements MqMessageService {

}