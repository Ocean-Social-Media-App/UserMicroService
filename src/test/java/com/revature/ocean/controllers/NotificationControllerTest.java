package com.revature.ocean.controllers;

import com.revature.ocean.services.UserService;
import com.revature.ocean.utility.JwtUtility;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
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
/*David: ... So. NotificationController.

AFAICT it can't be instantiated. Which means it can't be tested.*/

    /*
    NotificationController notificationController;
    UserService userService;
    JwtUtility jwtUtility;
    Map<String, String> headers = new HashMap<>();

    @BeforeEach
    public void setup(){

        jwtUtility = mock(JwtUtility.class);
        userService = mock(UserService.class);


        //notificationController = new NotificationController(userService, jwtUtility);

        //headers.put("authorization", "testing");
    }

    @Test
    public void getAll(){
        notificationController.getAllNotification(1,headers);
    }

    @Test
    public void getNull(){
        //when(headers.get("authorization")).thenReturn(null);
        headers.put("authorization", null);

        assertNull(notificationController.getAllNotification(1,headers));
    }
*/}