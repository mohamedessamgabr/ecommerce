package com.essam.ecommerce.service.impl;

import com.essam.ecommerce.dto.RoleDTO;
import com.essam.ecommerce.entity.Role;
import com.essam.ecommerce.mapper.RoleMapper;
import com.essam.ecommerce.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseServiceImpl<Role, RoleDTO, RoleDTO, RoleMapper, RoleRepository> {
    protected RoleService(RoleRepository repository, RoleMapper mapper) {
        super(repository, mapper);
    }
}
