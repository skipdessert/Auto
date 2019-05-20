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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesFotPost {
    private String url;
    private ResourceBundle bundle;
    CookieStore store;
    @BeforeTest
    public void setUrl() {
        bundle=ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("localhost");
    }
    @Test
    public void testGet() throws IOException {
        String uri=bundle.getString("gets");
        String testurl=url+uri;
        HttpGet get=new HttpGet(testurl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        String result =EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store=client.getCookieStore();
        List<Cookie> cookiesList= store.getCookies();
        for(Cookie cookie:cookiesList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+"  ;cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostWithCookies() throws IOException {
        String uri=bundle.getString("post");
        String testurl=url+uri;

        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client=new DefaultHttpClient();
        //声明一个方法，用这个方法就是post方法
        HttpPost post=new HttpPost(testurl);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","nihao");
        param.put("age","18");
        //设置请求头信息，设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个是对象来进行响应结果存储
        String result;
        //设施cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response=client.execute(post);
        //获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，判断是否符合预期



    }
}
