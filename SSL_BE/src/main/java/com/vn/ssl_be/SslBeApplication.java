package com.vn.ssl_be;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SslBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslBeApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();};
}
