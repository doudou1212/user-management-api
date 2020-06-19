package com.autraining.user.management.model;


import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @NonNull
    private String address;
}
