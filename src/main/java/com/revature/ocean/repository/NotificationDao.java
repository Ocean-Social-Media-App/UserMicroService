package com.revature.ocean.repository;

import com.revature.ocean.models.Notification;
import com.revature.ocean.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Zimi Li
 */
@Repository("NotificationDao")
@Transactional
public interface NotificationDao extends JpaRepository<Notification, Integer> {
    List<Notification> findTop10ByFeedAuthorOrderByTimestampDesc(User user);
    List<Notification> findByFeedAuthorOrderByTimestampDesc(User user);
}
