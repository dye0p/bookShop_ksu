package com.book.ksu.bookshop.dto;


import com.book.ksu.bookshop.domain.Role;
import com.book.ksu.bookshop.domain.UserEntity;
import lombok.Builder;
import lombok.Data;

public class UserDto {

    @Data
    @Builder
    public static class Request {
        private Long id;
        private String username;
        private String password;
        private String nickname;
        private String email;
        private Role role;

        public UserEntity toEntity() {
            UserEntity user = UserEntity.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .nickname(nickname)
                    .email(email)
                    .role(Role.USRE) //권한을 USER로 설정
                    .build();
            return user;
        }

    }


}
