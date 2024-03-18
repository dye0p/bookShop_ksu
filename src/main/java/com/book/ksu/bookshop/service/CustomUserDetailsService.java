package com.book.ksu.bookshop.service;

import com.book.ksu.bookshop.domain.UserEntity;
import com.book.ksu.bookshop.dto.CustomUserDetails;
import com.book.ksu.bookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService { //db에서 회원 정보를 가져옴

    private final UserRepository userRepository;

    /* username DB에 있는지 확인 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

        return new CustomUserDetails(userEntity);
    }
}
