package com.tuyennguyen.supeo.forum.service;

import com.tuyennguyen.supeo.forum.entity.UserDetailsSpringFW;
import com.tuyennguyen.supeo.forum.entity.User;
import com.tuyennguyen.supeo.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsSpringFWService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        new UserDetailsSpringFW(user.get());
//        return user.map(UserDetailsSpringFW::new).get();
        return new UserDetailsSpringFW(user.get());
    }

}
