package life.flidc.community.mapper;

import life.flidc.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Auther:flidc
 * @Date:2020/2/21
 * @Description:life.flidc.community.mapper
 * @Version:1.0
 */
@Mapper
public interface UserMapper {

//    @Select()
////    public User getUser();

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void save(User user);

    @Select("select * from user where token = #{token}")
    User getByToken(@Param("token") String token);

}
