package com.ebn.ebn.service;

import com.ebn.ebn.dto.UserDto;
import com.ebn.ebn.entity.UserEntity;
import com.ebn.ebn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    HashMap<Long, UserEntity> hashMap=new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    private Long generateId() {
        return hashMap.size() + 1L;
    }

    public UserDto add(UserEntity userEntity){
        userEntity.setId(generateId());
        userEntity.setValidationDate(LocalDate.now());
        userEntity.setCreationDate(LocalDate.now());
        userEntity.setLastModifiedDate(LocalDate.now());
        hashMap.put(userEntity.getId(),userEntity);
        return userMapper.toDto(userEntity);
    }


    public List<UserDto> getAllUsers() {
//        List<UserEntity> listUser=new ArrayList<>();
//        for(Map.Entry<Long,UserEntity> hm:hashMap.entrySet()){
//           listUser.add(hm.getValue());
//           return listUser.stream().map(userMapper::toDto).collect(Collectors.toList());
//        }

        return hashMap.values().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserEntity updatedEntity) {
        if(!hashMap.containsKey(id)){
            throw  new RuntimeException("id does not found");
        }
        updatedEntity.setId(id);
        updatedEntity.setValidationDate(LocalDate.now());
        updatedEntity.setCreationDate(hashMap.get(id).getCreationDate());
        updatedEntity.setLastModifiedDate(LocalDate.now());
        hashMap.put(id,updatedEntity);
        return userMapper.toDto(updatedEntity);
    }

    public String deleteUser(Long id) {
        if(!hashMap.containsKey(id)){
            throw  new RuntimeException("id does not found");
        }
        hashMap.remove(id);
        return "user deleted successfully";
    }
}
