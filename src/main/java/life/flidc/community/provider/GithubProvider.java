package life.flidc.community.provider;

import com.alibaba.fastjson.JSON;
import life.flidc.community.dto.AccessTokenDTO;
import life.flidc.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.provider
 * @Version:1.0
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String accessToken = string.split("&")[0].split("=")[1];
            return accessToken;
        } catch (IOException e) {
        }
        return null;
    }

    public GithubUser getGithubUser(String accessToken){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String str = response.body().string();
            return JSON.parseObject(str,GithubUser.class);
        } catch (IOException e) {
        }
        return null;
    }
}
