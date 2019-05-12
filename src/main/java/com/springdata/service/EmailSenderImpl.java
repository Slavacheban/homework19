package com.springdata.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Log4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailSenderImpl implements EmailSender {
    private final JavaMailSender emailSender;

    @Override
    public void send(String to, String title, String body) {
        MimeMessage message = this.emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(body);
            this.emailSender.send(message);
        } catch (MessagingException e) {
        }
    }
}
