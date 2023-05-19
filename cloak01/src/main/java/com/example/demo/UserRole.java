package com.example.demo;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {

    ADMIN("관리자"),
    USER("사용자");


    private final String title;

    public static UserRole of(String title) throws BusinessException {
        return Arrays.stream(values())
                .filter(v -> v.getTitle().equals(title))
                .findFirst().orElseThrow(() -> new BusinessException(title));
    }

    public String getCode() {
        return name();
    }
}