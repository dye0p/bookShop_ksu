package com.book.ksu.bookshop.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id값 자동증가
    private Long id;

    private String username;

    private String email;

    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

}
