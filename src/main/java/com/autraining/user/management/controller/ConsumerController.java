package com.autraining.user.management.controller;


import com.autraining.user.management.model.Consumer;
import com.autraining.user.management.model.Email;
import com.autraining.user.management.service.ApplicationService;
import com.autraining.user.management.service.CreateConsumerRequest;
import com.autraining.user.management.service.EmailManagementClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    private ApplicationService applicationService;

    @Autowired
   private EmailManagementClientService emailManagementClientService;


    @GetMapping
    public ResponseEntity<Page<Consumer>> getConsumersByName(@RequestParam("name") String name, Pageable pageable) {
//        Can use this to do customer sort
//        Pageable sortedByName =
//                PageRequest.of(0, 2, Sort.by("age").ascending());
        Page<Consumer> consumers = applicationService.findConsumerByName(name, pageable);
        return ResponseEntity.ok(consumers);
    }

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
        Email email = emailManagementClientService.getEmail(id);
        System.out.println(email);
        CreateConsumerRequest updatedRequest = CreateConsumerRequest.builder()
                .name(request.getName())
                .age(request.getAge())
                .email(email.getAddress())
                .build();
        Consumer consumer = applicationService.updateConsumerById(updatedRequest, id);
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
