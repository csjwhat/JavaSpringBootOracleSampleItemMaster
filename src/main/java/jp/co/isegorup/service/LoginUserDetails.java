package jp.co.isegorup.service;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.isegorup.domain.UserEntity;
import lombok.Data;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 2389204124517610893L;
    private final UserEntity userEntity;

    public LoginUserDetails(UserEntity userEntity) {
        super(userEntity.getUserName(), userEntity.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.userEntity = userEntity;
    }
}