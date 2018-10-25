package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.Result;
import com.onlineShop.service.BankAPIService;
import com.onlineShop.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public Result sendEmail(String emailAddress, String subject, String email) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        mailSender.setJavaMailProperties(props);
        mailSender.setUsername("pmonlineshopping2018@gmail.com");
        mailSender.setPassword("Project2018");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailAddress);
        mailMessage.setFrom("andres.mendez.cor@gmail.com");
        mailMessage.setSubject(subject);
        mailMessage.setText(email);

        mailSender.send(mailMessage);
        return new Result(0, "");
    }
}
