package com.course.sever;


import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class Mypostmethod {
    //这个变量用来装我们的cookies信息
    private static Cookie cookie;
    private HttpServletRequest request;
    private User u;
    //用户登录成功获取cookies，然后在访问其他接口获取列表

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "用户名",required = true) String username,
                        @RequestParam(value = "密码",required = true) String password){
        if (username.equals("zhangsan")&&password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜登陆成功！";
        }
        return "Y用户名或者密码错误";

    }
    @RequestMapping(value = "/getuserlist",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getuserlist(HttpServletRequest request,
                            @RequestBody User u){

        User user;
        //获取cookies
        Cookie[] cookies=request.getCookies();
        //验证cookies是否合法
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    && u.getUsername().equals("zhangsan")
                    && u.getPassword().equals("123456")){

                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";

    }
}
