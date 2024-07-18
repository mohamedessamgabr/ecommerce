package com.essam.ecommerce.mapper;

import com.essam.ecommerce.dto.UserDTO;
import com.essam.ecommerce.entity.Role;
import com.essam.ecommerce.entity.User;
import com.essam.ecommerce.repository.RoleRepository;
import com.essam.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserDTO, UserDTO> {

    private final UserRepository userRepository;

    @Override
    public User toEntity(UserDTO userDTO) {
        Optional<User> userOptional =  userRepository
                .findByEmail(userDTO.getEmail());
        User user = userOptional.orElse(new User());
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setMobileNumber(userDTO.getMobileNumber());
        return user;

    }

    @Override
    public UserDTO toPayload(User user) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public UserDTO toDTO(User user) {
        return UserDTO
                .builder()
                .id(user.getID())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .mobileNumber(user.getMobileNumber())
                .build();
    }
}
