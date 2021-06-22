package com.lvhongli.dao;

import com.lvhongli.model.User;
import org.springframework.data.jpa.repository.JpaRepository;




/**
 * Created by 瓦力.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
}
