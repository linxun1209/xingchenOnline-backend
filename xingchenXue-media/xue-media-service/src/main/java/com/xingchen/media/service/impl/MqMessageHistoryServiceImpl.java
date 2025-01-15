package com.xingchen.media.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingchen.media.mapper.MqMessageHistoryMapper;
import com.xingchen.media.service.MqMessageHistoryService;
import com.xingchen.domain.entity.MqMessageHistory;
import org.springframework.stereotype.Service;

/**
 * (MqMessageHistory)表服务实现类
 *
 * @author makejava
 * @since 2024-04-15 22:20:01
 */
@Service
public class MqMessageHistoryServiceImpl extends ServiceImpl<MqMessageHistoryMapper, MqMessageHistory> implements MqMessageHistoryService {

}