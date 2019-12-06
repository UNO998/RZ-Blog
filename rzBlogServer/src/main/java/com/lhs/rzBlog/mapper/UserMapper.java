package com.lhs.rzBlog.mapper;

import com.lhs.rzBlog.bean.Role;
import com.lhs.rzBlog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:  Haotao Lai (Eric)
 * Date:    2019-12-05
 * E-mail:  haotao.lai@gmail.com
 * Website: http://laihaotao.me
 */

@Mapper
@Repository
public interface UserMapper {

    User loadUserByName(@Param("username") String username);

//    long reg(User user);
//
//    int updateUserEmail(@Param("email") String email, @Param("id") Long id);
//
//    List<User> getUserByNickname(@Param("nickname") String nickname);
//
//    List<Role> getAllRole();
//
//    int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);
//
//    int deleteUserById(Long uid);
//
//    int deleteUserRolesByUid(Long id);
//
//    int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);
//
//    User getUserById(@Param("id") Long id);
}
