package com.api.sgpcbackend.service;

public interface EmailService
{
    public void sendEmail(String toEmail, String subject, String message);
}
