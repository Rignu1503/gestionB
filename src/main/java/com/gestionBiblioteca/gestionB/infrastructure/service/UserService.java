package com.gestionBiblioteca.gestionB.infrastructure.service;

import com.gestionBiblioteca.gestionB.api.dto.request.UserRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;
import com.gestionBiblioteca.gestionB.domain.entities.UserEntity;
import com.gestionBiblioteca.gestionB.domain.repositories.UserRepository;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.IUserService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import com.gestionBiblioteca.gestionB.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserResponse create(UserRQ request) {
        UserEntity user = userMapper.toUSer(request);
        UserEntity savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse get(Long id) {

        return this.userMapper.toUserResponse(userRepository.getOne(id));

    }

    @Override
    public UserResponse update(UserRQ request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sortType) {
        return null;
    }

    private UserEntity find(Long id){

        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el usuario"));
    }
}
