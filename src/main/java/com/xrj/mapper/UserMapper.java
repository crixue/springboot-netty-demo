package com.xrj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.xrj.pojo.User;
import com.xrj.util.MyMapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}