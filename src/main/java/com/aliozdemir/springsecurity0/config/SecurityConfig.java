package com.aliozdemir.springsecurity0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/account").authenticated()
                .antMatchers("/Balance").authenticated()
                .antMatchers("/Card").authenticated()
                .antMatchers("/Loans").authenticated()
                .antMatchers("/contact").permitAll()
                .antMatchers("/Notices").permitAll()
                .and().formLogin().and().httpBasic();

        http.authorizeRequests()
                .antMatchers("/","/index","/css/*","/js/*").permitAll()
                .anyRequest().authenticated().and().httpBasic();

       /*http.authorizeHttpRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();*/

       // http.authorizeHttpRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();

    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(
                "admin"
        ).password("12345").authorities("admin").and().withUser("ali").password("333").authorities("read").and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails ud1 = User.builder().username("admin").password("12345").authorities("admin").build();
        UserDetails ud2 = User.builder().username("ali").password("333").authorities("read").build();
        inMemoryUserDetailsManager.createUser(ud1);
        inMemoryUserDetailsManager.createUser(ud2);
        auth.userDetailsService(inMemoryUserDetailsManager);

    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoderTest encoderTest = new PasswordEncoderTest();
        encoderTest.md4Encoder();
        encoderTest.bcryptEncoder();
        encoderTest.standardEncoder();
        return new BCryptPasswordEncoder();
    }
}
