package jp.co.isegorup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.isegorup.domain.UserEntity;
import jp.co.isegorup.repository.UserRepository;

@Service
public class LoginUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findOne(username);
        if(user == null) {
            throw new UsernameNotFoundException("The requested user is not foud.");
        }
        return new LoginUserDetails(user);
    }
}