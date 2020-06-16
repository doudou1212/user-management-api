package com.autraining.user.management.controller;


import com.autraining.user.management.model.Consumer;
import com.autraining.user.management.service.ApplicationService;
import com.autraining.user.management.service.CreateConsumerRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Integer> createConsumer(@RequestBody CreateConsumerRequest request) {
        System.out.println("create consumer!");
        Integer id = applicationService.createConsumer(request);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumerById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(applicationService.findConsumerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(@PathVariable("id") Integer id, @RequestBody CreateConsumerRequest request) {
        System.out.println("update consumer!");
        Consumer consumer = applicationService.updateConsumerById(request, id);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(consumer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consumer> deleteConsumer(@PathVariable("id") Integer id) {
        System.out.println("delete consumer!");
        Consumer consumer = applicationService.deleteConsumerById(id);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(consumer);
    }
}
