package com.api.sgpcbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SolariumEmailService implements EmailService
{

    @Autowired
    private final JavaMailSender mailSender;

    @Async
    @Override
    public void sendEmail(String toEmail, String subject, String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("solariumsystemlabs@gmail.com");
        mailSender.send(mailMessage);
    }
}
