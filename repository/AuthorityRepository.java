package com.zz.staybooking.repository;
import com.zz.staybooking.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    //验证token是否有效，那么发送请求时就需要发送token
    //取出用户的权限，到时候判断权限是否能访问url
    Authority findAuthorityByUsername(String username);
}