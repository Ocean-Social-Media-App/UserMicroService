package com.revature.ocean.controllers;

import com.revature.ocean.services.NotificationService;
import com.revature.ocean.services.UserService;
import com.revature.ocean.utility.JwtUtility;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NotificationControllerTest {
    /*
        @Mock
    UserService userService;
    @Mock
    EmailService emailService;
    @Mock
    HttpSession session;
    @Mock
    JwtUtility jwtUtility;

    @BeforeEach
    void setUp() {
        this.userController = new UserController(userService, emailService, jwtUtility);
        User user = new User("Shane", "Password");
        userController.createUser(user);
    }
    * */
/*
    NotificationController notificationController;

    @Mock
    UserService userService;
    @Mock
    JwtUtility jwtUtility;
    @Mock
    NotificationService notificationService;

    Map<String, String> headers = new HashMap<>();

    @BeforeEach
    public void setup(){

/*        jwtUtility = mock(JwtUtility.class);
        userService = mock(UserService.class);
        notificationService = mock(NotificationService.class);*/
/*
        this.notificationController = new NotificationController(notificationService, userService, jwtUtility);

        headers.put("authorization", "testing");
    }

    @Test
    public void getAll(){
        this.notificationController.getAllNotification(1,headers);
    }

    @Test
    public void getNull(){
        //when(headers.get("authorization")).thenReturn(null);
        headers.put("authorization", null);

        assertNull(this.notificationController.getAllNotification(1,headers));
    }*/
}