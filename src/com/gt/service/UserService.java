package com.gt.service;

import com.gt.entity.UserEntity;

import java.util.List;

public interface UserService {

	boolean add(UserEntity userEntity);

	List<UserEntity> selectAll();

	boolean update(UserEntity userEntity);

	boolean del(String sid);
}
