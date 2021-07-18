package com.lvhongli.dao;


import com.lvhongli.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select  * from role  where user_id=:userId",nativeQuery = true)
    List<Role>  findAllByUserId(Integer userId);
}
