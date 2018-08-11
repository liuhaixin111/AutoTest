package com.course.sever;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class mygetmethod {

    @RequestMapping(value = "/getcookies",method = RequestMethod.GET)
    public String getcookies(HttpServletResponse response){
        //HttpServletRequest
        //HttpServletResponse
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "return cookies true!成功！";
    }
    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value = "/getwithcookies",method = RequestMethod.GET)
    public String getwithcookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "必须要有cookies才能访问成功";
        }
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "访问成功";
            }
        }
        return "必须要有cookies才能访问成功";
    }

}
