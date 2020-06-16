package com.autraining.user.management.repository;

import com.autraining.user.management.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

    Consumer findConsumerById(Integer id);
}
