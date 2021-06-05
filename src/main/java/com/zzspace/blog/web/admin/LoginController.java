package com.zzspace.blog.web.admin;

import com.zzspace.blog.model.dto.UserDTO;
import com.zzspace.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 76973 on 2021/5/16 21:49
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
        UserDTO userDTO = userService.checkUser(email, password);
        if (userDTO != null) {
            session.setAttribute("user", userDTO);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
