package com.autraining.user.management.service;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateConsumerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private Integer age;

    @NotBlank
    private String email;
}
