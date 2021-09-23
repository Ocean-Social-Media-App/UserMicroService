package com.revature.ocean.services;

import com.revature.ocean.models.Notification;
import com.revature.ocean.models.User;
import com.revature.ocean.models.UserResponse;
import com.revature.ocean.repository.NotificationDao;
import com.revature.ocean.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zimi Li
 */
@Service("NotificationService")
public class NotificationService {
    private NotificationDao notificationDao;
    private UserDao userDao;

    @Autowired
    public NotificationService(NotificationDao notificationDao, UserDao userDao) {
        this.notificationDao = notificationDao;
        this.userDao = userDao;
    }

    protected static void format(Notification notification) {
        /*notification.setFeedID(notification.getFeed().getId());*/
        notification.setUserResponse(UserService.format(notification.getUser()));
    }

    public List<Notification> getTop10NotificationByUserID(Integer userID) {
        User user = userDao.findById(userID).orElse(null);
        if (user == null) return null;
        List<Notification> notifications = notificationDao.findTop10ByUserOrderByTimestampDesc(user);
        notifications.forEach(NotificationService::format);
        user.setLastNotification(System.currentTimeMillis());
        userDao.save(user);
        return notifications;
    }

    public List<Notification> getNotificationByUserID(Integer userID) {
        User user = userDao.findById(userID).orElse(null);
        if (user == null) return null;
        List<Notification> notifications = notificationDao.findByUserOrderByTimestampDesc(user);
        notifications.forEach(NotificationService::format);
        user.setLastNotification(System.currentTimeMillis());
        userDao.save(user);
        return notifications;
    }
}
