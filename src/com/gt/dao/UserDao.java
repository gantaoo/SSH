package com.gt.dao;

import com.gt.entity.UserEntity;

import java.util.List;

public interface UserDao {

	boolean add(UserEntity userEntity);

	List<UserEntity> selectAll();

	boolean update(UserEntity userEntity);

	boolean del(String sid);
}
