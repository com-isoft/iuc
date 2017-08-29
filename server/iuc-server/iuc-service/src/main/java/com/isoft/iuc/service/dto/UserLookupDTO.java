package com.isoft.iuc.service.dto;

import com.isoft.ifx.service.dto.QueryDTO;
import com.isoft.iuc.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuqiang03 on 2017/6/23.
 */
@Getter
@Setter
@AllArgsConstructor
public class UserLookupDTO implements QueryDTO<User> {
    private String id;
    private String nickName;
    private String userName;
    private long version;
}