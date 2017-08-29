package com.isoft.iuc.service.dto;

import com.isoft.ifx.service.dto.QueryDTO;
import com.isoft.iuc.domain.enumeration.UserStatus;
import com.isoft.iuc.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsDTO implements QueryDTO<User>{
    private String nickName;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private UserStatus status;
    private String id;
}
