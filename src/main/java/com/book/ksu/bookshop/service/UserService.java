package com.book.ksu.bookshop.service;

import com.book.ksu.bookshop.dto.UserDto;
import com.book.ksu.bookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public void join(UserDto.Request userDto) {

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(userDto.toEntity());
    }


}
