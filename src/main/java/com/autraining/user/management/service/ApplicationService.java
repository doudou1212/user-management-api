package com.autraining.user.management.service;


import com.autraining.user.management.model.Consumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {
    Consumer findConsumerById(Integer id);

    Consumer updateConsumerById(CreateConsumerRequest request, Integer id);

    Integer createConsumer(CreateConsumerRequest request);

    Consumer deleteConsumerById(Integer id);

    Page<Consumer> findConsumerByName(String name, Pageable pageable);
}
