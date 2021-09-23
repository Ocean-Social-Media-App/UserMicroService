package com.revature.ocean.repository;

import com.revature.ocean.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository("userDao")
@Transactional
public interface UserDao extends JpaRepository<User, Integer> {
    //Find user by username
    User findUserByUsername(String username);
}
