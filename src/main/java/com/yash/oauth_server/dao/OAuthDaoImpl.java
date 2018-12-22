package com.yash.oauth_server.dao;

import com.yash.oauth_server.entity.Users;
import com.yash.oauth_server.repository.IOAuthRepository;
import com.yash.oauth_server.vo.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class OAuthDaoImpl implements IOAuthDao<Users, String> {

    private IOAuthRepository ioAuthRepository;

    public OAuthDaoImpl(IOAuthRepository ioAuthRepository) {this.ioAuthRepository = ioAuthRepository;}

    @Override
    public UserEntity getUserDetails(String username) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        Users users = ioAuthRepository.findByUsername(username);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(users.getUsername());
        userEntity.setPassword(users.getPassword());
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
        grantedAuthoritiesList.add(grantedAuthority);
        userEntity.setGrantedAuthoritiesList(grantedAuthoritiesList);
        return userEntity;
    }
}
