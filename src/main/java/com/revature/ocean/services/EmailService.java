package com.revature.ocean.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

/**
 * This service handles the emails that are sent to user's upon initial registration and when using the
 * password reset service.
 */
@Service("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailService(){
        javaMailSender = new JavaMailSenderImpl();
    }

    /**
     * Used to generate a new, random password that is visible to the user in the email they receive after
     * selecting "Forgot Password?" on the front end, and opening the email that they receive.
     *
     * @return  a string representing the user's new password used to sign into the front end
     */
    public String newPassword(){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<10; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    /**
     * This method emails the user a brief message and displays their new password.
     * This password will then be used to sign into the website.
     *
     * @param to            the email address to which the email is being sent
     * @param firstName     the first name of the user requesting a new password
     * @return              returns a String, representing the encoded password
     */
    public String sendNewPassword(String to, String firstName) {
        String pass = newPassword();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("oceansocailapp@gmail.com");
        message.setTo(to);
        message.setSubject("Ocean Social Password Reset");
        message.setText("Hello "+ firstName +",\n" +
                "This email is to confirm your password has been reset.\n" +
                "Please find your new password is.\n" +
                "\n"+
                "Password: " + pass + " \n" +
                "\n"+
                "\n"+
                "We recommend changing your password again after login in.\n"+
                "\n"+
                "If you did not request a password change please reach out to our administrators.\n" +
                "at oceansocailapp@gmail.com\n" +
                "Thank you and have a great day!\n" +
                "\n");
        javaMailSender.send(message);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pass);
    }

    /**
     * Sends an email to the user welcoming them to the Ocean social networking app upon initial registration
     *
     * @param to            email address to which the welcome email is being sent
     * @param firstName     first name of the user who registered for Ocean
     */
    public void welcomeEmail(String to, String firstName){
        System.out.println("EmailService.welcomeEmail");
        SimpleMailMessage welcome = new SimpleMailMessage();
        welcome.setFrom("oceansocailapp@gmail.com");
        welcome.setTo(to);
        welcome.setSubject("Welcome to Ocean Social");
        welcome.setText("Hello "+ firstName +",\n" +
                "This email is to confirm your account has been added\n" +
                " to the Ocean Social Application.\n" +
                "\n"+
                "\n"+
                "To get started please update your profile and then\n" +
                "get to posting in your 'Tide'.\n"+
                "\n"+
                "\n"+
                "Check out other peoples' post and view their profile.\n"+
                "\n"+
                "Leave comments and likes on your friends' post to show them some love. \n"+
                "\n"+
                "\n"+
                "If you have any issues please feel free to reach out to our administrators.\n" +
                "at oceansocailapp@gmail.com\n" +
                "\n"+
                "Thank you and have a great day!");
        javaMailSender.send(welcome);
    }
}
