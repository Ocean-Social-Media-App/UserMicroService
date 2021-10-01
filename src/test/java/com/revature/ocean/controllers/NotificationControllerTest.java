package com.revature.ocean.controllers;

import com.revature.ocean.models.Notification;
import com.revature.ocean.models.Response;
import com.revature.ocean.models.User;
import com.revature.ocean.services.EmailService;
import com.revature.ocean.services.NotificationService;
import com.revature.ocean.services.UserService;
import com.revature.ocean.utility.JwtUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;

import javax.servlet.http.HttpSession;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class NotificationControllerTest {
    //David: Notification controller keeps throwing a nullPointerException and I'm not sure what's wrong.
    NotificationController notificationController;

    @Mock
    UserService userService;
    @Mock
    NotificationService notificationService;
    @Mock
    HttpSession session;
    @Mock
    JwtUtility jwtUtility;

    @BeforeEach
    void setUp() {
        this.notificationController = new NotificationController(notificationService, userService, jwtUtility);
    }

    @Test
    public void getAllNotification(){
        //Assign
        User user = new User("user1", "password", "test1@test.com", "User1", "Test1", new Date() ,"About Me");
        User follow = new User("user2", "password", "test2@test.com", "User2", "Test2", new Date() ,"About Me");
        user.setUserId(1);
        follow.setUserId(2);

        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(new Notification(1,"follow",Long.parseLong("1633099934481"),follow,user,1,null,null));

        Map<String, String> headers = new HashMap<>();
        headers.put("userId", "1");
        headers.put("authorization", "testing");

        Response expectedResult = new Response(true, "retrieved notification", notificationList);
        //Mock
        Mockito.when(notificationService.getTop10NotificationByUserID(1)).thenReturn(notificationList);

        //Act
        Response actualResult = this.notificationController.getAllNotification(1,headers);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNull(){
        Map<String, String> headers = new HashMap<>();
        headers.put("userId", "1");
        headers.put("authorization", "testing");
        //when(headers.get("authorization")).thenReturn(null);
        headers.put("authorization", null);

        assertNull(this.notificationController.getAllNotification(1,headers));
    }
}