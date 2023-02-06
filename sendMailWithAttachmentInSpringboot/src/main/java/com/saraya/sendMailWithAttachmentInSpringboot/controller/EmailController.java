package com.saraya.sendMailWithAttachmentInSpringboot.controller;

import com.saraya.sendMailWithAttachmentInSpringboot.model.EmailSender;
import com.saraya.sendMailWithAttachmentInSpringboot.service.MailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    private final MailSenderService mailSenderService;

    public EmailController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/send_mail")
    public ResponseEntity sendMe(@RequestBody  EmailSender emailSender) throws MessagingException {
        this.mailSenderService.sendEmail(emailSender.getTo()
                ,emailSender.getSubject()
                ,emailSender.getMessage());
                //,emailSender.getAttachement());
        return  ResponseEntity.ok("email is sent successfully to " +emailSender.getTo());
    }
}
