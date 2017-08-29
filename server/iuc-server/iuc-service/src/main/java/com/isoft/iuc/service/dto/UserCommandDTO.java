package com.isoft.iuc.service.dto;

import com.isoft.ifx.service.dto.CommandDTO;
import com.isoft.iuc.domain.enumeration.UserStatus;
import com.isoft.iuc.domain.model.User;
import lombok.*;

/**
 * Created by liuqiang03 on 2017/6/26.
 */
@Getter
@Setter
@AllArgsConstructor
public class UserCommandDTO implements CommandDTO<User> {
    public UserCommandDTO(){
        this.status = UserStatus.ACTIVE;
    }
    private String nickName;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private UserStatus status;
    private String id;
    private long version;
}
