package com.isoft.iuc.domain.repository;

import com.isoft.ifx.domain.repository.JpaRepository;
import com.isoft.iuc.domain.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by liuqiang03 on 2017/6/22.
 */
@Repository
public interface UserRepository extends JpaRepository<User> {
}
