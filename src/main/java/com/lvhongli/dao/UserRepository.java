package com.lvhongli.dao;

import com.lvhongli.model.User;
import com.lvhongli.model.UserTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndType(@Param("username") String username,@Param("type") UserTypeEnum type);


}
