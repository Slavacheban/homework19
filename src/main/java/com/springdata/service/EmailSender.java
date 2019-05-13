package com.springdata.service;

public interface EmailSender {
    void send(String to, String title, String body);
}
