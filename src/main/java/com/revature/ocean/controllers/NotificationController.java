package com.revature.ocean.controllers;

import com.revature.ocean.models.Response;
import com.revature.ocean.models.Notification;
import com.revature.ocean.models.User;
import com.revature.ocean.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Zimi Li
 * NotificationController used to manage the endpoints associated with Notification methods.
 */
@RestController("NotificationController")
public class NotificationController {
    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * MIGHT NOT BE NECESSARY, POSSIBLE REMOVAL
     * @param req
     * @return
     */
    @GetMapping("notification-preview")
    public Response getPreviewNotification(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("loggedInUser");
        if (user == null)
            return new Response(false, "Session not found", null);
        List<Notification> notifications = notificationService.getTop10NotificationByUserID(user.getUserId());
        if (notifications == null)
            return new Response(false, "User ID not found", null);
        else
            return new Response(true, "retrieved notification", notifications);
    }

    /**
     * Creates the API endpoint to get all notifications for the logged in user.
     *
     * @param req   THIS WILL CHANGE WHEN JWT IMPLEMENTED
     * @return      returns a response indicating success (true/false), the message, and data returned
     */
    @GetMapping("notification")
    public Response getAllNotification(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("loggedInUser");
        if (user == null)
            return new Response(false, "Session not found", null);
        List<Notification> notifications = notificationService.getNotificationByUserID(user.getUserId());
        if (notifications == null)
            return new Response(false, "User ID not found", null);
        else
            return new Response(true, "retrieved notification", notifications);
    }
}
