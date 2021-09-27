package com.revature.ocean.listener;

import com.revature.ocean.models.Notification;
import com.revature.ocean.models.RabbitMessage;
import com.revature.ocean.services.NotificationService;
import com.revature.ocean.services.UserService;
import com.revature.ocean.utility.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class RabbitListener {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private RabbitTemplate template;

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = MQConfig.POST)
    public void getPostNotificationFromFeedService(RabbitMessage message) {
        Notification notification = new Notification();
        notification.setUserFrom(this.userService.getUserById(message.getUserIdFrom()));
        notification.setUserBelongTo(this.userService.getUserById(message.getUserIdTo()));
        notification.setFeedId(message.getPostId());
        notification.setTimestamp(System.currentTimeMillis());
        notification.setType("comment");
        this.notificationService.createNotification(notification);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = MQConfig.LIKE)
    public void getLikeNotificationFromFeedService(RabbitMessage message) {
        Notification notification = new Notification();
        notification.setUserFrom(this.userService.getUserById(message.getUserIdFrom()));
        notification.setUserBelongTo(this.userService.getUserById(message.getUserIdTo()));
        notification.setFeedId(message.getPostId());
        notification.setTimestamp(System.currentTimeMillis());
        notification.setType("like");
        this.notificationService.createNotification(notification);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = MQConfig.USER)
    public void getUserIdFromFeedService(Integer userId){
        System.out.println(userId);
        System.out.println(this.userService.getFollowing(1));
//        template.convertAndSend(
//                MQConfig.EXCHANGE,
//                MQConfig.FOLLOWINGS,
//                this.userService.getFollowing(userId)
//        );
    }
}