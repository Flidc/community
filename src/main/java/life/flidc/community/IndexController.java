package life.flidc.community;

import life.flidc.community.mapper.UserMapper;
import life.flidc.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.community
 * @Version:1.0
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies ) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.getByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";

    }
}
