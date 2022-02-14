package com.tuyennguyen.supeo.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SupeoForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupeoForumApplication.class, args);
    }

    @GetMapping("show")
    public String showData() {
        return "data 2";
    }

    @GetMapping("admin/product")
    public String product() {
        return "show product";
    }

}
