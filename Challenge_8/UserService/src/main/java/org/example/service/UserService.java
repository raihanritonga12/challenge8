package org.example.service;

import org.example.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {
    List<UserEntity> cariSemuaUser();
    Optional<UserEntity> cariDariID(Long id);
    UserEntity simpanUser(UserEntity userEntity);
    UserEntity updateUser(Long id, UserEntity userEntity);
    String deleteUser(Long id);
}