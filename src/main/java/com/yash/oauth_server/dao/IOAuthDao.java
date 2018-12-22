package com.yash.oauth_server.dao;

import com.yash.oauth_server.vo.UserEntity;

import java.io.Serializable;

public interface IOAuthDao<T, String extends Serializable> {
    UserEntity getUserDetails(String username);
}
