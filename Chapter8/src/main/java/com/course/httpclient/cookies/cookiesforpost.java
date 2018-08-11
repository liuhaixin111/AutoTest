package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class cookiesforpost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforetest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testgetcookies() throws IOException {
        String result;
        String uri = bundle.getString("getcookies.uri");
        String testurl = url+uri;

        //测试逻辑
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieslist = store.getCookies();
        for(Cookie cookie : cookieslist){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies name = "+name+",cookies value = "+value);
        }
    }
    @Test(dependsOnMethods = "testgetcookies")
    public void testpostwithcookies() throws IOException {
        String uri = bundle.getString("test.postwithcookies");
        String testurl = uri+url;

        //声明一个client对象
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个post方法
        HttpPost post = new HttpPost(testurl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","liuhaixin");
        param.put("age","20");
        //设置请求头信息
        post.setHeader("content-type","application/json");
        //将参数信息添加至方法
        StringEntity entity = new StringEntity(param.toString());
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);


        JSONObject resultjson = new JSONObject(result);
        //具体判断返回的值

        //获取结果值
        String seccess = (String) resultjson.get("status");
        //判断返回结果是否符合预期
        Assert.assertEquals("1",seccess);
    }

}
