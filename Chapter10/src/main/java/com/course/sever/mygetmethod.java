package com.course.sever;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class mygetmethod {

    @RequestMapping(value = "/getcookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获得Cookies",httpMethod = "GET")
    public String getcookies(HttpServletResponse response) {
        //HttpServletRequest
        //HttpServletResponse
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "return cookies true!成功！";
    }

    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value = "/getwithcookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getwithcookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "必须要有cookies才能访问成功";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "访问成功";
            }
        }
        return "必须要有cookies才能访问成功";
    }

    /**
     * 开发一个需要参数才能访问的get请求
     * 第一种实现方式 url：key=value&key=value
     * 模拟获取商品列表
     */
    @RequestMapping(value = "/get/withpara", method = RequestMethod.GET)
    @ApiOperation(value = "需要参数才能访问的get请求",httpMethod = "GET")
    public Map<String, Integer> getlist(@RequestParam Integer star, @RequestParam Integer end) {
        Map<String, Integer> list = new HashMap<>();
        list.put("鞋", 123);
        list.put("asa", 1234);
        return list;

    }

    /**
     * 开发二种需要参数才能访问的get请求
     * url:ip:port/get/with/para/10/20
     * 模拟获取商品列表
     */
    @RequestMapping(value = "/get/withparam/{star}/{end}")
    @ApiOperation(value = "需要参数才能访问的get请求第二种实现",httpMethod = "GET")
    public Map<String, Integer> mygetlist(@PathVariable Integer star, @PathVariable Integer end) {
        Map<String, Integer> list = new HashMap<>();
        list.put("鞋", 123);
        list.put("asa", 1234);
        return list;


    }
}