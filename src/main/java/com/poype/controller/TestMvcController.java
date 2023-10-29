package com.poype.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@RequestMapping("/mvc")
@RestController
public class TestMvcController {

    // 完整的path是类上的注解和方法上的注解共同决定的
    @GetMapping("/test_get_mapping")   // 完整的path是 /mvc/test_get_mapping
    public String testGetMapping() {
        System.out.println("testGetMapping method is invoked");
        return "test get mapping";
    }

    // 利用@PathVariable 可以支持restful风格的请求
    @GetMapping("/test_path_variable/{id}")
    public String testPathVariable(@PathVariable("id") String id) {
        System.out.println("testPathVariable method is invoked, id = " + id);
        return "test path variable" + id;
    }

    /**
     * MVC的handler方法可以支持如下原生参数
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * InputStream  等价于 request.getInputStream()
     * OutputStream 等价于 response.getOutputStream()
     * Reader 等价于 request.getReader()
     * Writer 等价于 response.getWriter()
     * Locale
     * java.security.Principal
     */
    @GetMapping("/servlet")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session, Writer writer) throws IOException {
        System.out.println("request: " + request);
        System.out.println("response: " + response);
        System.out.println("session: " + session);

        writer.write("test servlet api");   // 方法的返回值为void，通过write API向client返回数据
    }
}
