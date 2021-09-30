package com.example.swagger.utils;

import com.example.swagger.dto.UsersDTO;
import com.example.swagger.model.Users;

public class ConvertObject {
    public static Users convertUserDTOToUsers(UsersDTO usersDTO) {
        Users users = new Users();
        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());
        return users;
    }
}
