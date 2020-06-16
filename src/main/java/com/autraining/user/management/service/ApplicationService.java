package com.autraining.user.management.service;


import com.autraining.user.management.model.Consumer;

public interface ApplicationService {
    Consumer findConsumerById(Integer id);

    Consumer updateConsumerById(CreateConsumerRequest request, Integer id);

    Integer createConsumer(CreateConsumerRequest request);

    Consumer deleteConsumerById(Integer id);
}
