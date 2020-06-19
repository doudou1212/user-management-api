package com.autraining.user.management.service;


import com.autraining.user.management.model.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailHystrics implements EmailManagementClientService{
    @Override
    public Email getEmail(Integer userId) {
        return new Email("mockEmail@mock.com");
    }
}
