package com.dbc.pessoaapi.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebSecurityConfigTest {

    @Test
    public void generatePass() {
        System.out.println(new BCryptPasswordEncoder().encode("marcelo"));
    }
}