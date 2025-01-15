package com.xingchen.media.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingchen.domain.entity.MqMessageHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * (MqMessageHistory)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-15 22:20:01
 */
@Mapper
public interface MqMessageHistoryMapper extends BaseMapper<MqMessageHistory> {

}