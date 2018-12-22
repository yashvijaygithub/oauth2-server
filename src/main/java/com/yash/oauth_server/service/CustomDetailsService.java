package com.yash.oauth_server.service;

import com.yash.oauth_server.dao.IOAuthDao;
import com.yash.oauth_server.vo.CustomUser;
import com.yash.oauth_server.vo.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsService implements UserDetailsService {
    private IOAuthDao oauthDao;

    public CustomDetailsService(IOAuthDao oauthDao) {this.oauthDao = oauthDao;}

    @Override
    public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity userEntity = null;
        try {
            userEntity = oauthDao.getUserDetails(username);
            CustomUser customUser = new CustomUser(userEntity);
            return customUser;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }
}
