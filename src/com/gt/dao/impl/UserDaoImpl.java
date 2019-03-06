package com.gt.dao.impl;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gt.dao.UserDao;
import com.gt.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl  implements UserDao {

 
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean add(UserEntity userEntity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(userEntity);
			return true;
		}catch (Exception e) {
			e.getStackTrace();
			System.out.println(""+ e.getMessage());
			return false;
		}
	}

    @Override
    public List<UserEntity> selectAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria =session.createCriteria(UserEntity.class);
        List<UserEntity> list = criteria.list();
        return list;
    }

	@Override
	public boolean update(UserEntity userEntity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			UserEntity u = session.get(UserEntity.class,userEntity.getSid());
			u.setUsername(userEntity.getUsername());
			u.setPassword(userEntity.getPassword());
			session.update(u);
			return true;
		}catch (Exception e) {
			e.getStackTrace();
			System.out.println(""+ e.getMessage());
			return false;
		}
	}

	@Override
	public boolean del(String sid) {
		Session session = sessionFactory.getCurrentSession();
		try {
		    UserEntity u =	session.get(UserEntity.class,sid);
			session.delete(u);
			return true;
		}catch (Exception e) {
			e.getStackTrace();
			System.out.println(""+ e.getMessage());
			return false;
		}
	}
}

