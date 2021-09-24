package com.revature.ocean.services;

import com.revature.ocean.models.User;
import com.revature.ocean.repository.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    UserService userService;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    UserDao userDao;
    User shane;

    @BeforeEach
    void setUp() { this.userService = new UserService(userDao);
        shane = mock(User.class);
    }

    @Test
    void format() {
    }

    @Test
    void login() {
    }

    @Test
    void checkForUser() {
    }

    @Test
    void createUser() {
    }

    @Test
    void forGotInfo() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getBookmarks() {
    }

    @Test
    void setBookmark() {
    }

    @Test
    void removeBookmark() {
    }

    @Test
    void getFollowers() {
    }

    @Test
    void setFollowers() {
    }

    @Test
    void removeFollowers() {
    }
}