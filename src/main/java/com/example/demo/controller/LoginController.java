package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/index")
public class LoginController {
@GetMapping()
    public String login(HttpServletRequest req, HttpServletResponse resp)throws IOException {

        System.out.println("请求到来");
        resp.setCharacterEncoding("GBK");
        // 微信加密签名
        String signature = req.getParameter("signature");
        System.out.println(signature);
        // 时间戳
        String timestamp = req.getParameter("timestamp");
        System.out.println(timestamp);
        // 随机数
        String nonce = req.getParameter("nonce");
        System.out.println(nonce);
        // 随机字符串
        String echostr = req.getParameter("echostr");
        PrintWriter pw = resp.getWriter();
        pw.write(echostr);  //这里 echostr 的值必须返回，否则微信认为请求失败
        pw.flush();
        pw.close();
        return "index";
    }
}
