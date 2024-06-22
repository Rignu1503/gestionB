package com.gestionBiblioteca.gestionB.infrastructure.service;

import com.gestionBiblioteca.gestionB.api.dto.request.UserRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;
import com.gestionBiblioteca.gestionB.api.exections.BadRequestException;
import com.gestionBiblioteca.gestionB.domain.entities.UserEntity;
import com.gestionBiblioteca.gestionB.domain.repositories.UserRepository;
import com.gestionBiblioteca.gestionB.infrastructure.abtract_service.IUserService;
import com.gestionBiblioteca.gestionB.utils.enums.SortType;
import com.gestionBiblioteca.gestionB.utils.mappers.UserMapper;
import com.gestionBiblioteca.gestionB.utils.messages.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

        return this.userMapper.toUserResponse(this.find(id));

    }

    @Override
    public UserResponse update(UserRQ request, Long id) {

        UserEntity user = this.find(id);

        userMapper.updateUser(request, user);
        UserEntity savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public void delete(Long id) {

        UserEntity user = this.find(id);
        this.userRepository.delete(user);

    }

    @Override
    public Page<UserResponse> getAll(int page, int size, SortType sortType) {


        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.userRepository.findAll(pagination).map(userMapper::toUserResponse);
    }

    private UserEntity find(Long id){

        return this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorMessages.IdNotFound("user")));
    }
}
