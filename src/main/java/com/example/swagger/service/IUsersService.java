package com.example.swagger.service;

import com.example.swagger.dto.UsersDTO;
import com.example.swagger.model.Users;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users save(UsersDTO usersDTO);

    Users update(long id, UsersDTO usersDTO);

    Users updatePassword(long id, String password);

    Users deleteById(long id);
}
