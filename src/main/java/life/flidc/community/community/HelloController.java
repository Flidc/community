package life.flidc.community.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.community
 * @Version:1.0
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";

    }
}