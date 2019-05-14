package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.demo.enums.InitName.TOKEN;

@RestController
@RequestMapping("/index")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @GetMapping()
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");//随机字符串
        String sortStr = loginService.sort(TOKEN, timestamp, nonce); /**
         * 字符串进行shal加密
         */String mySignature = loginService.shal(sortStr); /**
         * 校验微信服务器传递过来的签名 和  加密后的字符串是否一致, 若一致则签名通过
         */if (!"".equals(signature) && !"".equals(mySignature) && signature.equals(mySignature)) {
            System.out.println("-----签名校验通过-----");
            resp.getWriter().write(echostr);
        } else {
            System.out.println("-----校验签名失败-----");
        }

    }
}
