package com.autraining.user.management.controller;


import com.autraining.user.management.model.Consumer;
import com.autraining.user.management.service.ApplicationService;
import com.autraining.user.management.service.CreateConsumerRequest;
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
