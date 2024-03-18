package com.book.ksu.bookshop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨.
@Configuration
public class SecurityConfig { //시큐리티 config

    @Bean
    public PasswordEncoder passwordEncoder() { //사용자가 입력한 패스워드 암호화
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/user/**").permitAll()
                        .anyRequest().authenticated()
                )

                //로그인 처리
                .formLogin((auth) -> auth // 로그인 폼 출력
                        .loginPage("/user/login")// 커스텀 로그인 페이지 경로 설정
                        .loginProcessingUrl("/user/loginProc") //로그인 데이터가 넘어가는 URI
                        .defaultSuccessUrl("/")
                        .permitAll()
                )

                .logout((auth) -> auth
                        .logoutUrl("/logout")//로그아웃 요청 URL 설정,
                        .logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL 설정
                        .invalidateHttpSession(true) //Http 세션 무효화
                        .deleteCookies("JSESSIONID") //로그아웃시 쿠키 삭제
                )

        ;

        //csrf 토큰 disable
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
}
