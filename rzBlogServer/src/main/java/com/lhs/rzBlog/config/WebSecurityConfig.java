package com.lhs.rzBlog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhs.rzBlog.common.JsonResponse;
import com.lhs.rzBlog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

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
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(jsonInputUserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("/admin/category/all").authenticated()
                .antMatchers("/admin/**", "/reg").hasRole(ADMIN_ROLE)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage(LOGIN_PAGE)
                    .loginProcessingUrl(PROCESSING_URL)
                    .permitAll()
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
        return new MessageDigestPasswordEncoder("MD5");
    }


    @Bean
    public AccessDeniedHandler getAccessDeniedHandler() {
        return (req, res, err) -> {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.setCharacterEncoding("UTF-8");
            try (PrintWriter out = res.getWriter()) {
                out.write("You don't have authorization to do so, please contact the administrator.");
                out.flush();
            }
        };
    }

    @Bean
    public JsonInputUserAuthenticationFilter jsonInputUserAuthenticationFilter() throws Exception {
        JsonInputUserAuthenticationFilter filter = new JsonInputUserAuthenticationFilter();
        filter.setAuthenticationSuccessHandler((req, res, err) -> {
            JsonResponse tmp = new JsonResponse()
                    .code(HttpStatus.OK.value())
                    .message("login successfully");

            res.setContentType("application/json;charset=utf-8");
            try (PrintWriter out = res.getWriter()) {
                out.write(tmp.json());
                out.flush();
            }
        });
        filter.setAuthenticationFailureHandler((req, res, err) -> {
            JsonResponse tmp = new JsonResponse()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("fail to login");

            res.setContentType("application/json;charset=utf-8");
            try (PrintWriter out = res.getWriter()) {
                out.write(tmp.json());
                out.flush();
            }
        });

        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    public static class JsonInputUserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            if (!request.getMethod().equals("POST")) {
                throw new AuthenticationServiceException(
                        "Authentication method not supported: " + request.getMethod());
            }

            if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
                ObjectMapper mapper = new ObjectMapper();
                UsernamePasswordAuthenticationToken authRequest = null;
                try (InputStream is = request.getInputStream()) {
                    Map<String, String> authenticationBean = mapper.readValue(is, Map.class);
                    authRequest = new UsernamePasswordAuthenticationToken(
                            authenticationBean.get(USERNAME_PARAM), authenticationBean.get(PASSWORD_PARAM));
                } catch (IOException e) {
                    e.printStackTrace();
                    authRequest = new UsernamePasswordAuthenticationToken(
                            "", "");
                } finally {
                    setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            } else {
                return super.attemptAuthentication(request, response);
            }
        }


    }

}
