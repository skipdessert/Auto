package get;

import bean.user;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取cookiespost请求
 */
@RestController
@Api(value="/",description = "这是我全部的post请求")
@RequestMapping(value="/vv")
public class MyPostMethod {
    //用来装cookies信息
    private static Cookie cookie;
    //用户登录成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ApiOperation(value="登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value="username",required = true) String username,
                        @RequestParam(value="password",required = true) String password){
        if (username.equals("zhangsan")&&password.equals("123")){
            cookie=new Cookie("xiaofan","0429");
            response.addCookie(cookie);
            return "恭喜登陆成功";
        }
        return "用户名或密码错误";
    }
    /**
     * 获取列表
     */
    @RequestMapping(value="/list",method=RequestMethod.POST)
    @ApiOperation(value="获取用户列表",httpMethod = "POST")
    private String gerUserList(HttpServletRequest request,
                             @RequestBody user u){
        user uu;
        //获取cookies
        Cookie[] cookies=request.getCookies();
        //验证合法性
        for (Cookie cookie:cookies){
            if (cookie.getValue()=="0429"&&cookie.getName()=="xiaofan"){
                 uu=new user();
                uu.setAge("9");
                uu.setName("蛋蛋");
                return uu.toString();
            }
        }
        return "参数不合法";
    }

}
