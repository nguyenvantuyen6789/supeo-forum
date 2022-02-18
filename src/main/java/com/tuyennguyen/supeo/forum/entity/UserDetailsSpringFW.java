package com.tuyennguyen.supeo.forum.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsSpringFW implements UserDetails {

    private User user;
//    private String username;
//    private String password;
//    private Boolean active;
//    private List<GrantedAuthority> authorities;

    public UserDetailsSpringFW() {

    }

    public UserDetailsSpringFW(User user) {
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.active = user.getActive();
//        this.authorities = Arrays.stream(user.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        super();
        this.user = user;
    }

    @Override
    public String getUsername() {
//        return username;
        return user.getUsername();
    }

    @Override
    public String getPassword() {
//        return password;
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
//        return active;
        return user.getActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
        String roles = user.getRoles();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles);
        return Collections.singleton(grantedAuthority);
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

}
