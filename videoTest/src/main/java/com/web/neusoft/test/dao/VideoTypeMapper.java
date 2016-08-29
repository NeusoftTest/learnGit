package com.web.neusoft.test.dao;

import com.web.neusoft.test.model.VideoType;

public interface VideoTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoType record);

    int insertSelective(VideoType record);

    VideoType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VideoType record);

    int updateByPrimaryKey(VideoType record);
}