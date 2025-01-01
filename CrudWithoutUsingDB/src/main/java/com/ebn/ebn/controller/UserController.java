package com.ebn.ebn.controller;

import com.ebn.ebn.dto.UserDto;
import com.ebn.ebn.entity.UserEntity;
import com.ebn.ebn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public ResponseEntity<?> add( @Valid @RequestBody UserEntity userEntity){
        return  ResponseEntity.ok(userService.add(userEntity));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserEntity updatedEntity){
        return ResponseEntity.ok(userService.updateUser(id,updatedEntity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }



}
