package life.flidc.community;

import life.flidc.community.dto.AccessTokenDTO;
import life.flidc.community.dto.GithubUser;
import life.flidc.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.community
 * @Version:1.0
 */
@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;
    @Value("${github.client.id}")
    String githubId;
    @Value("${github.client.secret}")
    String githubSecret;
    @Value("${github.redirect.uri}")
    String githubRedirectUri;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(githubId);
        accessTokenDTO.setClient_secret(githubSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(githubRedirectUri);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        System.out.println(githubUser.getName());
        System.out.println(githubUser.getId());
        return "index";
    }
}
