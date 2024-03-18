package com.book.ksu.bookshop.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role { //권한
    USRE("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String value;
}
