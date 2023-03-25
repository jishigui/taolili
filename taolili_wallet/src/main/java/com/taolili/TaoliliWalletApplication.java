package com.taolili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taolili.mapper")
public class TaoliliWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaoliliWalletApplication.class, args);
    }
}
