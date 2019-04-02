package com.example.fw.main.c;

import com.example.fw.main.Annotation.AuthToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 宋宗垚
 * @Date 2019/4/2 9:26
 * @Description TODO
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello(Integer id, String name, Integer age) {
        System.out.println("hello方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "hi~ I need no auth";
    }
    @GetMapping("user")
    @AuthToken
    public String user(Integer id, String name, Integer age) {
        System.out.println("user方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "hi~ I need login ";
    }
    @GetMapping("admin")
    @AuthToken(role_name = { "admin", "Administrator" })
    public String admin(Integer id, String name, Integer age) {
        System.out.println("admin方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "hi~ I need admin";
    }


}
