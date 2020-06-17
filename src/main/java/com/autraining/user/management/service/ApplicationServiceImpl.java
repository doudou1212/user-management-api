package com.autraining.user.management.service;

import com.autraining.user.management.model.Consumer;
import com.autraining.user.management.repository.ConsumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;

@Component
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
    private ConsumerRepository consumerRepository;

    @Override
    public Consumer findConsumerById(Integer id) {
        return consumerRepository.findConsumerById(id);
    }

    @Override
    public Integer createConsumer(CreateConsumerRequest request) {
        var consumer = Consumer.builder()
                .age(request.getAge())
                .email(request.getEmail())
                .name(request.getName())
                .build();

        try {
            consumerRepository.save(consumer);
        } catch (PersistenceException e) {
            throw new RuntimeException("failed to create consumer" + e.getMessage());
        }
        return consumer.getId();
    }

    @Override
    public Consumer updateConsumerById(CreateConsumerRequest request, Integer id) {
        var consumer = Consumer.builder()
                .id(id)
                .age(request.getAge())
                .email(request.getEmail())
                .name(request.getName())
                .build();

        try {
            return consumerRepository.save(consumer);
        } catch (PersistenceException e) {
            throw new RuntimeException("failed to create consumer" + e.getMessage());
        }
    }

    @Override
    public Consumer deleteConsumerById(Integer id) {
        var consumer = consumerRepository.findConsumerById(id);
        consumerRepository.deleteById(id);
        return consumer;
    }

    @Override
    public Page<Consumer> findConsumerByName(String name, Pageable pageable) {
        return consumerRepository.findConsumerByName(name, pageable);
    }

}
