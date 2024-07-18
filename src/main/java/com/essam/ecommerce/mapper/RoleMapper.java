package com.essam.ecommerce.mapper;

import com.essam.ecommerce.dto.RoleDTO;
import com.essam.ecommerce.entity.Role;
import com.essam.ecommerce.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapper implements BaseMapper<Role, RoleDTO, RoleDTO> {
    private final RoleRepository roleRepository;
    @Override
    public Role toEntity(RoleDTO roleDTO) {
        return roleRepository
                .findByName(roleDTO.getName())
                .orElse(Role
                        .builder()
                        .name(roleDTO.getName())
                        .build());
    }

    @Override
    public RoleDTO toPayload(Role role) {
        return RoleDTO
                .builder()
                .name(role.getName())
                .id(role.getID())
                .build();
    }

    @Override
    public RoleDTO toDTO(Role role) {
        return RoleDTO
                .builder()
                .name(role.getName())
                .id(role.getID())
                .build();
    }
}
