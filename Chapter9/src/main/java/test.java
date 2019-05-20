import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class test {
    private String url;
    //读取配置文件的工具
    private ResourceBundle bundle;
    CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("localhost");

    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("gets");
        String testuri=url+uri;
        //测试
        HttpGet get=new HttpGet(testuri);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
//        this.store=client.getCookieStore();
//        List<Cookie> cookiesList= store.getCookies();
//        for(Cookie cookie:cookiesList){
//            String name=cookie.getName();
//            String value=cookie.getValue();
//            System.out.println("cookie name="+name+"  ;cookie value="+value);
//        }
    }
//    @Test(dependsOnMethods = {"testGetCookies"})
//    public void testGetWithCookies() throws IOException {
//        String uri=bundle.getString("request");
//        String testurl=uri+url;
//        HttpGet get=new HttpGet(testurl);
//        DefaultHttpClient client=new DefaultHttpClient();
//        //设置cookies信息
//        client.setCookieStore(this.store);
//        HttpResponse response= client.execute(get);
//        //获取响应状态码
//        int statusCode=response.getStatusLine().getStatusCode();
//        System.out.println(statusCode);
//        String result=EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(result);
//    }

}

