package vn.iotstar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.iotstar.entity.Role;
import vn.iotstar.entity.User;
import vn.iotstar.repository.RoleRepository;
import vn.iotstar.repository.UserRepository;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(new Role("ROLE_USER")));

            if (userRepository.findByUsername("user01").isEmpty()) {
                User user = new User();
                user.setUsername("user01");
                user.setEmail("user01@gmail.com");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setFullName("Nguyễn Hữu Trung");
                user.setImages("/images/user.png");
                user.setRole(userRole);
                user.setEnabled(true);
                userRepository.save(user);
            }
        };
    }
}
