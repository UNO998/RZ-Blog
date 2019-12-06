package com.lhs.rzBlog.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author:  Haotao Lai (Eric)
 * Date:    2019-12-05
 * E-mail:  haotao.lai@gmail.com
 * Website: http://laihaotao.me
 */

@Data
public class User implements UserDetails {

    // user table content for mapper
    private Long id;
    private boolean enabled;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userface;
    private Timestamp regTime;

    // for authorization purpose
    List<Role> roles;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(r ->
                authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName().toUpperCase()))
        );
        return authorities;
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
