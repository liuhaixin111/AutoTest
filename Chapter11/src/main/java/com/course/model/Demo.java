package com.course.model;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@Api(value = "v1",description = "这是我第一个版本的demo")
@RequestMapping("v1")
public class Demo {

    //首先获取一个执行aql语句的对象
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int intgetUserList(){

        return  template.selectOne("getUserCount");

    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUesr(@RequestBody User user){
        return template.insert("addUser",user);
    }

    @RequestMapping(value = "/updataUser",method = RequestMethod.POST)
    public int updataUser(@RequestBody User user){
        return template.update("updataUser",user);
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public int delUser(@RequestParam int id){
        return template.delete("delUser",id);


    }

}
