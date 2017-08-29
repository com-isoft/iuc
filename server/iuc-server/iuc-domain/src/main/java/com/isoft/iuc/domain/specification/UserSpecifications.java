package com.isoft.iuc.domain.specification;

import com.isoft.iuc.domain.model.User;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by liuqiang03 on 2017/6/26.
 */
public class UserSpecifications {
    public static Specification<User> userNameSpec(String code) {
        return (root, criteriaQuery, cb) -> cb.equal(root.get("userName"), code);
    }
}
