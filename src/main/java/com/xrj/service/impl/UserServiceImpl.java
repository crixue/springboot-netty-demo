package com.xrj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xrj.mapper.UserMapper;
import com.xrj.pojo.User;
import com.xrj.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Cacheable(value="3600", key="'getUserByUuid' + #uuid")
	public User getUserByUuid(String uuid) {
		User record = new User();
		record.setUserUuid(uuid);
		return userMapper.selectOne(record);
	}

}
