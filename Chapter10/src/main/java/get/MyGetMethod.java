package get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyGetMethod {
    @RequestMapping(value="/ss",method=RequestMethod.GET)
    public String getcookies(HttpServletResponse response){
        Cookie cookie=new Cookie("password","123");
        response.addCookie(cookie);
        return "供你去你大爷的";
    }
}
