package dev.naveenkumar.springbootmongo.service;

import dev.naveenkumar.springbootmongo.dto.UserDto;
import dev.naveenkumar.springbootmongo.model.User;
import dev.naveenkumar.springbootmongo.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest(properties = "spring.profiles.active.test")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRepository userRepository;

    public void test_saveUser() {
        UserDto userDto = UserDto.builder().country("IN").name("test-user").username("test-username").build();

        userService.saveUser(userDto.convertToUser());

        List<User> users = userRepository.findAll();

        Assertions.assertAll();
    }
}

