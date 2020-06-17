package com.autraining.user.management.repository;

import com.autraining.user.management.model.Consumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

    Consumer findConsumerById(Integer id);

    Page<Consumer> findConsumerByName(String name, Pageable pageable);
}
