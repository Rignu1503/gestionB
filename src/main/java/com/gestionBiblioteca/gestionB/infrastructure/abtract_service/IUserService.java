package com.gestionBiblioteca.gestionB.infrastructure.abtract_service;

import com.gestionBiblioteca.gestionB.api.dto.request.UserRQ;
import com.gestionBiblioteca.gestionB.api.dto.response.UserResponse;

public interface IUserService extends CRUD<UserRQ, UserResponse, Long>{

    public final String FIELD_BY_SORT = "full_name";
}
