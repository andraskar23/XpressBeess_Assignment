package com.ebn.ebn.mapper;

import com.ebn.ebn.dto.UserDto;
import com.ebn.ebn.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") //this Makes the mapper a Spring Bean
public interface UserMapper {


    @Mapping(source = "shippingId",target = "awdNumber")
    @Mapping(source = "ewayBillNumb",target = "ebnNumber")
    UserDto toDto(UserEntity userEntity);


    @Mapping(source = "awdNumber",target = "shippingId")
    @Mapping(source = "ebnNumber",target = "ewayBillNumb")
    UserEntity toEntity(UserDto userDto);
}
