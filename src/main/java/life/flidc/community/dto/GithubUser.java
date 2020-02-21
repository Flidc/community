package life.flidc.community.dto;

/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.dto
 * @Version:1.0
 */
public class GithubUser {

    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
