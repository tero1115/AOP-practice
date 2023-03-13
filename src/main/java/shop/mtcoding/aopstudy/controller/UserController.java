package shop.mtcoding.aopstudy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.aopstudy.handler.aop.LoginUser;
import shop.mtcoding.aopstudy.model.User;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final HttpSession session;

    @GetMapping("/login")
    public String login() {
        User user = new User(1, "ssar", "1234", "0102222");
        session.setAttribute("principal", user);
        return "login ok";
    }

    @GetMapping("/user/1") // 인증 필요 없음
    public String userInfo() {
        return "user ok";
    }

    @GetMapping("/auth/1")
    public String authInfo(@LoginUser User user) { // 인증 필요함
        System.out.println("자동으로 값 주입됨");
        System.out.println(user.getUsername());
        return "auth ok";
    }
}