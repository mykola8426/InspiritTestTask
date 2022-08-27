package com.example.tripapp.config;

import com.example.tripapp.model.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
    private static final String USER = Role.RoleName.USER.name();
    private static final String ADMIN = Role.RoleName.ADMIN.name();
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public BasicConfiguration(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.GET,"/tickets", "/locations",
                        "/tours", "/tour-operators", "/locations/by-country",
                        "/tickets/by-price").hasRole(USER)
                .antMatchers(HttpMethod.PUT, "/tickets", "/locations",
                        "/tours", "/tour-operators").hasRole(ADMIN)
                .antMatchers(HttpMethod.DELETE, "/tickets", "/locations",
                        "/tours", "/tour-operators").hasRole(ADMIN)
                .antMatchers(HttpMethod.POST, "/tickets", "/locations", "/tours",
                        "/tour-operators").hasRole(ADMIN)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic();
    }


}
