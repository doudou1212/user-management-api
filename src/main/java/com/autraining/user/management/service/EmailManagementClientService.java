package com.autraining.user.management.service;

import com.autraining.user.management.model.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-email-management", fallback = EmailHystrics.class  )
public interface EmailManagementClientService {
    @GetMapping("/emails/{user_id}")
    public Email getEmail(@PathVariable("user_id") Integer userId);
}
