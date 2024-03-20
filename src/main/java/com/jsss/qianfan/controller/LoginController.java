package com.jsss.qianfan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,String username){
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        return "登录成功";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request,String username){
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        return "登出成功";
    }


    @GetMapping("/status")
    @ResponseBody
    public String status(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username =(String)session.getAttribute("username");
        if (username!=null&&!username.isEmpty()){
            return username;
        }else {
            return "没有登录";
        }
    }
}
