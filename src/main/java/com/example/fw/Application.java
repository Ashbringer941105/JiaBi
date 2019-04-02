package com.example.fw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("com.example.*")
@ServletComponentScan//自定义拦截器
@EnableWebMvc//mvc模式，使用拦截器必须添加此注解
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("===============");
    }
    /**
     * 所有的打印调用这里，便于统一清除
     * */
    public static void out(Object s) {
		System.out.println("8081:"+s);
    }
    public static void out() {
        out("");
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(DataSize.ofBytes(104857600L));
        /// 总上传数据大小
        factory.setMaxFileSize(DataSize.ofBytes(1048576000L));
        return factory.createMultipartConfig();
    }

}
