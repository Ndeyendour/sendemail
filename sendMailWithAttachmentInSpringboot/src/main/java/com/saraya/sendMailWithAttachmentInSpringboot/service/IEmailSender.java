package com.saraya.sendMailWithAttachmentInSpringboot.service;

import javax.mail.MessagingException;

public interface IEmailSender {
    public void sendEmail(String to, String subject, String message
            //,String attachement
    ) throws MessagingException;
}

