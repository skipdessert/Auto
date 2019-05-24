package get;

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
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value="/ss",method=RequestMethod.GET)
    @ApiOperation(value="通过这个方法可以获取到cookies",httpMethod = "get")
    public String getcookies(HttpServletResponse response){
        Cookie cookie=new Cookie("password","123");
        response.addCookie(cookie);
        return "给客户端返回cookies的get接口";
    }

    /**
     *开发一个必须携带cookies的get请求
     */
    @RequestMapping(value="/request",method=RequestMethod.GET)
    @ApiOperation(value = "开发一个必须携带cookies的get请求",httpMethod = "get")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookie=request.getCookies();
        if (Objects.isNull(cookie)){
            return "必须携带cookies";
        }
        for (Cookie cookie1:cookie){
            if (cookie1.getName().equals("login")&&cookie1.getValue().equals("true")){
                return "恭喜你访问成功";
            }
        }
        return "必须携带cookies";

    }
    /**
     * 开发一个必须携带参数的get请求
     * 第一种方式url：key value
     */
    @RequestMapping(value="/getlist",method=RequestMethod.GET)
    @ApiOperation(value="开发一个必须携带参数的get请求\n" +
            "     * 第一种方式url：key value",httpMethod = "get")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("球鞋",900);
        myList.put("衬衫",300);
        myList.put("篮球",400);
        return  myList;
    }
    /**
     * 第二种需要携带参数访问的get请求
     * url：getlist/10/20
     */
    @RequestMapping(value="/param/{start}/{end}",method=RequestMethod.GET)
    @ApiOperation(value="开发一个必须携带参数的get请求\n" +
            "     * 第二种方式url：key value",httpMethod = "get")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("球鞋",900);
        myList.put("衬衫",300);
        myList.put("篮球",400);
        return  myList;
    }
}
