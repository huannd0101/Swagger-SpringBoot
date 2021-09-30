package com.example.swagger.service.imp;

import com.example.swagger.dto.UsersDTO;
import com.example.swagger.exception.NotFoundException;
import com.example.swagger.model.Users;
import com.example.swagger.repository.UsersRepository;
import com.example.swagger.service.IUsersService;
import com.example.swagger.utils.ConvertObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImp implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users save(UsersDTO usersDTO) {
        return usersRepository.save(ConvertObject.convertUserDTOToUsers(usersDTO));
    }

    @Override
    public Users update(long id, UsersDTO usersDTO) {
        Optional<Users> optional = usersRepository.findById(id);
        Users users = ConvertObject.convertUserDTOToUsers(usersDTO);
        if(!optional.isPresent()){
            throw new NotFoundException("Not found user by id = " + id);
        }
        users.setId(optional.get().getId());
        usersRepository.save(users);
        return users;
    }

    @Override
    public Users updatePassword(long id, String password) {
        Optional<Users> optional = usersRepository.findById(id);
        if(optional.isPresent()){
            throw new NotFoundException("Not found user by id = " + id);
        }

        Users users = optional.get();
        users.setPassword(password);
        usersRepository.save(users);
        return users;
    }

    @Override
    public Users deleteById(long id) {
        Optional<Users> optional = usersRepository.findById(id);
        if(!optional.isPresent()) {
            throw new NotFoundException("Not found user by id = " + id);
        }
        usersRepository.deleteById(id);
        return optional.get();
    }
}
