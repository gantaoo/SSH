package com.gt.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.dao.UserDao;
import com.gt.entity.UserEntity;
import com.gt.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public boolean add(UserEntity userEntity) {
		return userDao.add(userEntity);
	}

	@Override
	public List<UserEntity> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public boolean update(UserEntity userEntity) {
		return userDao.update(userEntity);
	}

	@Override
	public boolean del(String sid) {
		return userDao.del(sid);
	}


}
