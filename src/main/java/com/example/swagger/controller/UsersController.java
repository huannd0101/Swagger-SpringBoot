package com.example.swagger.controller;

import com.example.swagger.dto.UsersDTO;
import com.example.swagger.service.IUsersService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value = "User APIs")
public class UsersController {

    @Autowired
    IUsersService iUsersService;

    @ApiOperation(value = "Xem danh sách user", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thành công"),
            @ApiResponse(code = 401, message = "Chưa xác thực"),
            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
            @ApiResponse(code = 404, message = "Không tìm thấy")
    })
    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(iUsersService.findAll());
    }

    @ApiOperation(value = "Thêm mới một user")
    @PostMapping("")
    public ResponseEntity<?> createNewUser(
            @ApiParam(value = "Đối tượng user cần tạo mới", required = true)
            @RequestBody UsersDTO usersDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iUsersService.save(usersDTO));
    }

    @ApiOperation(value = "Update thông tin của user với id chuyền vào")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserById(
            @ApiParam(value = "Id của username cần update", required = true)
            @PathVariable("id") Long id,
            @ApiParam(value = "Đối tượng mang thông tin update", required = true)
            @RequestBody UsersDTO usersDTO){

        return ResponseEntity.status(200).body(iUsersService.update(id, usersDTO));
    }

    @ApiOperation(value = "Delete user với id chuyền vào")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(
            @ApiParam(value = "Id của user cần delete", required = true)
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(iUsersService.deleteById(id));
    }
}
