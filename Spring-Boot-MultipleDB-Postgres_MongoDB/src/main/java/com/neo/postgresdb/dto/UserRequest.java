package com.neo.postgresdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserRequest {
	private String uname;
    private String email;
    private String password;
    private String mobileNum;
}
