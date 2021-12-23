package com.aliozdemir.springsecurity0.config;

import com.aliozdemir.springsecurity0.entity.DigitalUser;
import com.aliozdemir.springsecurity0.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DigitalUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DigitalUser user = userRepository.findByIdentityNo(username);
        if(user == null){
            throw new UsernameNotFoundException("Digital user not found");
        }
        return new DigitalUserDetails(user);
    }
}
