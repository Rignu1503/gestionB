package com.gestionBiblioteca.gestionB.api.dto.response;

import com.gestionBiblioteca.gestionB.utils.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
    private String full_name;
}
