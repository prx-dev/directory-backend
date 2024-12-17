package com.prx.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DirectoryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectoryBackendApplication.class, args);
    }

}
