package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Mycookies {
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
    public void testgetwithcookies() throws IOException {
        String uri = bundle.getString("test.getwithcookies");
        String testurl = url+uri;
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statuscode = response.getStatusLine().getStatusCode();
        System.out.println("statuscode = "+statuscode);

        if(statuscode == 200){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }

    }

}
