package com.example.fw.main.c;

import com.example.fw.base.RequestType;
import com.example.fw.main.Annotation.AuthToken;
import com.example.fw.main.s.RequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RequestTypeService requestTypeService;

    @GetMapping("hello")
    public RequestType hello(Integer id, String name, Integer age) {
        System.out.println("hello方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return requestTypeService.sendTrue("hello");
    }
    @GetMapping("user")
    @AuthToken
    public RequestType user(Integer id, String name, Integer age) {
        System.out.println("user方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);

        return requestTypeService.sendTrue("user");
    }
    @GetMapping("admin")
    @AuthToken(role_name = { "admin", "Administrator" })
    public RequestType admin(Integer id, String name, Integer age) {
        System.out.println("admin方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return requestTypeService.sendTrue("admin");
    }


}
