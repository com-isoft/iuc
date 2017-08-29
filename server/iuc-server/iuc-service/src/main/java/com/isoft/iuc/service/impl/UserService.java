package com.isoft.iuc.service.impl;

import com.isoft.ifx.core.filter.Filter;
import com.isoft.ifx.domain.model.UserInfo;
import com.isoft.ifx.domain.specification.FilterSpecification;
import com.isoft.ifx.service.support.AbstractService;
import com.isoft.iuc.domain.model.User;
import com.isoft.iuc.domain.repository.UserRepository;
import com.isoft.iuc.domain.specification.UserSpecifications;
import com.isoft.iuc.service.dto.UserCommandDTO;
import com.isoft.iuc.service.dto.UserDetailsDTO;
import com.isoft.iuc.service.dto.UserLookupDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by liuqiang03 on 2017/6/22.
 */
@Service
public class UserService extends AbstractService<User, UserCommandDTO> implements UserDetailsService {

    private BCryptPasswordEncoder encoder;
    @Autowired
    public UserService(UserRepository repository, Mapper mapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repository, mapper);
        this.encoder = bCryptPasswordEncoder;
    }

    @Override
    public UserInfo loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetailsDTO dto = getRepository().findOne(UserDetailsDTO.class, UserSpecifications.userNameSpec(name));
        return new UserInfo() {
            @Override
            public String getNickName() {
                return dto.getNickName();
            }

            @Override
            public String getId() {
                return dto.getId();
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return dto.getPassword();
            }

            @Override
            public String getUsername() {
                return dto.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    @Override
    public Page<UserLookupDTO> list(Filter filter, Pageable pageable) {
        return this.findAll(UserLookupDTO.class, filter, pageable);
    }

    @Override
    public Page<UserLookupDTO> lookUp(Filter filter, Pageable pageable) {
        return getRepository().findAll(UserLookupDTO.class, new FilterSpecification<>(filter), pageable);
    }

    @Override
    protected UserRepository getRepository() {
        return (UserRepository) super.getRepository();
    }

    @Transactional
    @Override
    public UserCommandDTO add(UserCommandDTO dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        return super.add(dto);
    }

    @Transactional
    @Override
    public UserCommandDTO edit(UserCommandDTO dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        return super.edit(dto);
    }
}
