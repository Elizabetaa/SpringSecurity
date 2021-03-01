package com.example.demo.service.impl;

import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.entities.UserRoleEntity;
import com.example.demo.model.entities.enums.RoleName;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initUsers() {

        if (userRepository.count() == 0) {
            UserRoleEntity admin = new UserRoleEntity().setRole(RoleName.ADMIN);
            UserRoleEntity user = new UserRoleEntity().setRole(RoleName.USER);

            userRoleRepository.saveAll(List.of(admin, user));

            UserEntity userEntityAdmin = new UserEntity().setUsername("admin").setPassword(passwordEncoder.encode("topsecret"));
            UserEntity userEntity = new UserEntity().setUsername("user").setPassword(passwordEncoder.encode("topsecret"));
            userEntityAdmin.setRoles(List.of(admin,user));
            userEntity.setRoles(List.of(user));

            userRepository.save(userEntityAdmin);
            userRepository.save(userEntity);
        }
    }
}
