package com.web.neusoft.test.dao;

import com.web.neusoft.test.model.UserMassage;

public interface UserMassageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMassage record);

    int insertSelective(UserMassage record);

    UserMassage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMassage record);

    int updateByPrimaryKey(UserMassage record);
}