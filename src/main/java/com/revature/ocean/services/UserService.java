package com.revature.ocean.services;

import com.revature.ocean.models.User;
import com.revature.ocean.models.Response;
import com.revature.ocean.models.UserResponse;
import com.revature.ocean.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){this.userDao = userDao;}

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    protected static UserResponse format(User user) {
        return new UserResponse(user.getUserId(), user.getUsername(), user.getProPicUrl(), user.getLastNotification());
    }

    //Login
    public User login(User user){
        User tempUser = checkForUser(user.getUsername());
        //checks if the search returns a user object
        if(tempUser != null){
            //Checks to make sure their passwords match
            boolean isPasswordMatch = passwordEncoder.matches(user.getPassword(), tempUser.getPassword());
            if(isPasswordMatch){
                return tempUser;
            }
        }
        return null;
    }

    //Checks for if a User is in the Database
    public User checkForUser(String username){ return this.userDao.findUserByUsername(username); }

    //Register/signUp user
    public User createUser(User user) {
        //check to see if user is already in database
        User tempUser = checkForUser(user.getUsername());
        //If username is not found in database it will create the user
        if (tempUser == null) {
            String bcPass = user.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encode = passwordEncoder.encode(bcPass);
            user.setPassword(encode);
            return this.userDao.save(user);
        }
        //if tempUser returns something from database it'll return null as username is in use
        return null;
    }

    //If User forgot login info
    public User forGotInfo(String username) {
        //check to see if user is already in database
        return checkForUser(username);
    }

    //Will update User
    public User updateUser(User user) {
        //Gets the user from Database
        User dataBaseUser =this.userDao.findUserByUsername(user.getUsername());
        //Checks to see if a result was returned
        if(dataBaseUser != null){
            //To make sure the ID & Password doesn't get changed by anyone
            user.setUserId(dataBaseUser.getUserId());
            user.setPassword(dataBaseUser.getPassword());
            //Executes the update
            this.userDao.save(user);
            //Returns the updated user
            return user;
        }
        return null;
    }

    //Will get a user by Id
    public User getUserById(Integer userId) {
        return this.userDao.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        List<User> users = this.userDao.findAll();
        for(User a : users){
            a.setPassword(null);
        }
        return users;
    }

    public Set<Integer> getBookmarks(Integer userId){
        User user = this.userDao.findById(userId).orElse(null);
        Set<Integer> bookmarks = user.getBookmarks();
        return bookmarks;
    }

    public Set<Integer> setBookmark(Integer userId, Integer postId){
        User user = this.userDao.findById(userId).orElse(null);
        Set<Integer> bookmarks = user.getBookmarks();
        bookmarks.add(postId);
        user.setBookmarks(bookmarks);
        this.userDao.save(user);
        return bookmarks;
    }
    //David: Testing if I can commit and add things
    public Set<Integer> removeBookmark(Integer userId, Integer postId){
        User user = this.userDao.findById(userId).orElse(null);
        Set<Integer> bookmarks = user.getBookmarks();
        bookmarks.remove(postId);
        user.setBookmarks(bookmarks);
        this.userDao.save(user);
        return bookmarks;
    }

    public Set<Integer> getFollowers(Integer userId){
        User user = this.userDao.findById(userId).orElse(null);
        Set<Integer> bookmarks = user.getBookmarks();
        return bookmarks;
    }

    public Set<Integer> setFollowers(Integer userId){
        User user = this.userDao.findById(userId).orElse(null);
        Set<Integer> followers = user.getFollowers();
        followers.add(user.getUserId());
        user.setFollowers(followers);
        this.userDao.save(user);
        return followers;
    }

    public Set<Integer> removeFollowers(Integer userId){
        User user = this.userDao.findById(userId).orElse(null);
        Set<Integer> followers = user.getFollowers();
        followers.add(userId);
        user.setFollowers(followers);
        this.userDao.save(user);
        return followers;
    }
}
