package com.lhs.rzBlog.config;

import com.lhs.rzBlog.common.JsonResponse;
import com.lhs.rzBlog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Created by Yiran Shen, Haotao Lai
 * 12/03/2019
 */

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // should be put as the content of front-end login form 'action' attribute
    private final String PROCESSING_URL = "/login";

    // for internal usage
    private final static String ADMIN_ROLE = "ADMIN";
    private final static String USER_ROLE = "USER";
    private final static String LOGIN_PAGE = "/login_page";
    private final static String USERNAME_PARAM = "username";
    private final static String PASSWORD_PARAM = "password";

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        log.info("using data from {} for authentication", authDataSource);
//        ConfigStrategy configer;
//        if (Objects.equals(authDataSource, IM_MEMORY_DS)) {
//            configer = new InMemoryStrategy();
//        } else {
//            configer = new DatabaseStrategy();
//        }
//        configer.config(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/category/all").authenticated()
                .antMatchers("/admin/**", "/reg").hasRole(ADMIN_ROLE)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .usernameParameter(USERNAME_PARAM)
                    .passwordParameter(PASSWORD_PARAM)
                    .loginPage(LOGIN_PAGE)
                    .loginProcessingUrl(PROCESSING_URL)
                    .permitAll()
                    .successHandler((req, res, err) -> {
                        JsonResponse tmp = new JsonResponse()
                                .code(HttpStatus.OK.value())
                                .message("login successfully");

                        res.setContentType("application/json;charset=utf-8");
                        try(PrintWriter out = res.getWriter()) {
                            out.write(tmp.json());
                            out.flush();
                        }
                    })
                    .failureHandler((req, res, err) -> {
                        JsonResponse tmp = new JsonResponse()
                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message("fail to login");

                        res.setContentType("application/json;charset=utf-8");
                        try(PrintWriter out = res.getWriter()) {
                            out.write(tmp.json());
                            out.flush();
                        }
                    })
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .csrf()
                    .disable()
                    .exceptionHandling()
                    .accessDeniedHandler(getAccessDeniedHandler())
        ;
    }

    /* disable password encoder for now
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */

    @Bean
    public AccessDeniedHandler getAccessDeniedHandler() {
        return (req, res, err) -> {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.setCharacterEncoding("UTF-8");
            try(PrintWriter out = res.getWriter()) {
                out.write("You don't have authorization to do so, please contact the administrator.");
                out.flush();
            }
        };
    }

/*
    private interface ConfigStrategy {
        void config(AuthenticationManagerBuilder builder) throws Exception;
    }

    private static class InMemoryStrategy implements ConfigStrategy {

        @Override
        public void config(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("yiran").password("{noop}yiran").roles(ADMIN_ROLE)
                    .and()
                    .withUser("jingye").password("{noop}jingye").roles(ADMIN_ROLE)
                    .and()
                    .withUser("haotao").password("{noop}haotao").roles(ADMIN_ROLE)
                    .and()
                    .withUser("user").password("{noop}12345").roles(USER_ROLE);
        }
    }

    private class DatabaseStrategy implements ConfigStrategy {

//        @Autowired
//        UserService userService;

        @Override
        public void config(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService);
        }
    }

 */
}
