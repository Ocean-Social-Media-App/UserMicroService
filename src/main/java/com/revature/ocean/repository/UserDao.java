package com.revature.ocean.repository;

import com.revature.ocean.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Repository("userDao")
@Transactional
public interface UserDao extends JpaRepository<User, Integer> {
    //Find user by username
    User findUserByUsername(String username);
    HashSet<Integer> findBookmarks(Integer userId);
    HashSet<Integer> setBookmark(Integer userId, Integer postId);
    HashSet<Integer> removeBookmark(Integer userId, Integer postId);
}
