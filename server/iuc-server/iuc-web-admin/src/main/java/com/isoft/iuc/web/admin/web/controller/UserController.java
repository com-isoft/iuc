package com.isoft.iuc.web.admin.web.controller;

import com.isoft.ifx.web.controller.AbstractController;
import com.isoft.iuc.domain.model.User;
import com.isoft.iuc.service.dto.UserCommandDTO;
import com.isoft.iuc.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by liuqiang03 on 2017/6/27.
 */
@RequestMapping("/users")
@RestController
public class UserController extends AbstractController<User, UserCommandDTO> {
    @Autowired
    public UserController(UserService service) {
        super(service);
    }
}
