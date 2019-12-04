package com.lhs.rzBlog.config;

import com.lhs.rzBlog.common.JsonResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Yiran
 * 12/03/2019
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final String ADMIN_ROLE = "ADMIN";
	private final String USER_ROLE = "USER";

    // should be put as the content of front-end login form 'action' attribute
    private final String PROCESSING_URL = "/login";

    private final String LOGIN_PAGE = "/login_page";
    private final String USERNAME_PARAM = "username";
    private final String PASSWORD_PARAM = "password";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("yiran").password("yiran").roles(ADMIN_ROLE)
				.and()
				.withUser("jingye").password("jingye").roles(ADMIN_ROLE)
				.and()
				.withUser("haotao").password("haotao").roles(ADMIN_ROLE)
				.and()
				.withUser("user").password("12345").roles(USER_ROLE);
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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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
}
