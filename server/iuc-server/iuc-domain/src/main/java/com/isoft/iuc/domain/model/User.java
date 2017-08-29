package com.isoft.iuc.domain.model;

import com.isoft.ifx.core.annotation.Description;
import com.isoft.ifx.domain.model.AbstractAuditableAggregateRoot;
import com.isoft.ifx.domain.model.LogicalRemovable;
import com.isoft.iuc.domain.enumeration.UserStatus;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 用户信息
 * Created by liuqiang03 on 2017/6/22.
 */
@Entity
@Table(name = "user_info")
@Description("用户信息")
public class User extends AbstractAuditableAggregateRoot implements LogicalRemovable {

    public User() {
        this.status = UserStatus.ACTIVE;
    }

    @Column(nullable = false, length = 32)
    @NotNull(message = "昵称不能为空！")
    @Length(max = 32, min = 2, message = "昵称的长度在2和32之间!")
    @Description("昵称")
    private String nickName;

    @Column(nullable = false, length = 32, unique = true)
    @NotNull(message = "用户名不能为空！")
    @Length(max = 32, min = 4, message = "用户名的长度在4和32之间!")
    @Description("用户名")
    private String userName;

    @Column(nullable = false, length = 64)
    @NotNull(message = "密码不能为空！")
    @Description("密码")
    private String password;

    @Column(length = 12)
    @Description("手机")
    private String phone;

    @Column(length = 64)
    @Email(message = "邮箱格式不合法")
    @Description("邮箱")
    private String email;

    @Description("用户状态")
    @Type(type = "com.isoft.ifx.domain.type.BitEnumType")
    private UserStatus status;

    @Description("是否删除")
    @Column(name = "deleted")
    private boolean deleted;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}