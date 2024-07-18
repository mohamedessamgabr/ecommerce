package com.essam.ecommerce.service.impl;

import com.essam.ecommerce.dto.UserDTO;
import com.essam.ecommerce.entity.User;
import com.essam.ecommerce.mapper.UserMapper;
import com.essam.ecommerce.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<User, UserDTO, UserDTO,
        UserMapper,
        UserRepository> implements UserDetailsService {
    protected UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return super.repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

}
