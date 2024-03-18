package com.book.ksu.bookshop.controller;

import com.book.ksu.bookshop.dto.UserDto;
import com.book.ksu.bookshop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    //회원가입 페이지
    @GetMapping("/user/join")
    public String joinP() {
        return "user/join";
    }

    //회원가입
    @PostMapping("/user/joinProc")
    public String join(UserDto.Request userDto) {

        userService.join(userDto);

        return "redirect:/user/login"; //회원가입이 완료되면 로그인 페이지로 리다이렉트
    }

    //로그인 페이지
    @GetMapping("/user/login")
    public String loginP() {
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }
}
