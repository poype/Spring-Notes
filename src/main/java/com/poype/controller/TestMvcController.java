package com.poype.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

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

    // ModelAttribute注解声明的方法会先于所有的handler方法被调用
    @ModelAttribute
    public void setValueToRequest(Map<String, Object> map) {
        System.out.println("setValueToRequest method is invoked");

        TestRequest request = new TestRequest();
        request.setName("test_name");
        request.setAge(22);
        request.setDescription("test for model attribute");

        map.put("abc", request); // 在model中加入一个对象，key是abc
        // 如果这里用"testRequest"(类名首字母小写)作为key，那么在handler方法中就不用@ModelAttribute明确指定key了
    }

    @GetMapping("/test_model_attribute")
    public String testModelAttribute(@ModelAttribute("abc") TestRequest abc) { // 从model中取出key是abc的对象，作为方法的参数
        System.out.println(abc);  // TestRequest{name='test_name', age=22, description='test for model attribute'}
        return "SUCCESS";
    }
    // 方法的参数也可以不用@ModelAttribute注解指定key的名字，如果没有用@ModelAttribute指定key的名字，那么它会自动使用类名首字母小写作为key，
    // 在本例中默认的key是testRequest

    @GetMapping("test_exception")
    public String testException(@RequestParam("number") int number) {
        System.out.println(10 / number);
        return "Success";
    }
}
