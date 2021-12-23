package com.aliozdemir.springsecurity0.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Slf4j
@Configuration
public class PasswordEncoderTest {

    public void md4Encoder() {

        Md4PasswordEncoder md5PasswordEncoder = new Md4PasswordEncoder();
        String encoded = md5PasswordEncoder.encode("12345");

        log.info("Md4 encoded -> {}",encoded);
    }

    public void bcryptEncoder() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encoded = bCryptPasswordEncoder.encode("12345");

        log.info("Bcrypt encoded -> {}",encoded);
    }

    public void standardEncoder() {

        StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
        String encoded = standardPasswordEncoder.encode("Kalem2016");

        log.info("Standart encoded -> {}",encoded);
    }
}
