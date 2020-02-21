package life.flidc.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.community
 * @Version:1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";

    }
}
