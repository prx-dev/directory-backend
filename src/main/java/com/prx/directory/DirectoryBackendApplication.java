package com.prx.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.prx.directory.client")
@SpringBootApplication(
        scanBasePackages = {
                "com.prx.directory",
                "com.prx.commons.properties",
                "com.prx.security"
        }
)
public class DirectoryBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(DirectoryBackendApplication.class, args);
    }
}
