package com.autraining.user.management;

import com.autraining.user.management.model.Consumer;

public class Fixture {

    public static Consumer mockConsumer(Integer id) {
        return Consumer.builder()
                .id(id)
                .name("consumer1")
                .age(18)
                .email("consumer1@example.com")
                .build();
    }
}
