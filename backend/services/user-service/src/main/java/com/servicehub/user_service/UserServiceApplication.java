package com.servicehub.user_service;

import com.servicehub.user_service.entity.User;
import com.servicehub.user_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner createDefaultAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            String adminEmail = "admin@servicehub.com";

            // Check whether admin already exists
            if (userRepository.findByEmail(adminEmail).isEmpty()) {

                User admin = new User();

                admin.setName("ServiceHub Admin");
                admin.setEmail(adminEmail);
                admin.setPassword(
                        passwordEncoder.encode("Admin@123")
                );
                admin.setRole("ADMIN");

                userRepository.save(admin);

                System.out.println(
                        "=========================================="
                );

                System.out.println(
                        "Default ADMIN account created successfully!"
                );

                System.out.println(
                        "Email: admin@servicehub.com"
                );

                System.out.println(
                        "Password: Admin@123"
                );

                System.out.println(
                        "=========================================="
                );

            } else {

                System.out.println(
                        "Default ADMIN account already exists."
                );
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}