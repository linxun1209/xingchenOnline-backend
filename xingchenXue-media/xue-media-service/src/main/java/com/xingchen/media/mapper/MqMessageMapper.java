package com.xingchen.media.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingchen.domain.entity.MqMessage;
import org.apache.ibatis.annotations.Mapper;

/**
 * (MqMessage)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-15 22:19:36
 */
@Mapper
public interface MqMessageMapper extends BaseMapper<MqMessage> {

}