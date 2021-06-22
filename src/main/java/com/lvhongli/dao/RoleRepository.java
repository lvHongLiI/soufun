package com.lvhongli.dao;


import com.lvhongli.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 角色数据DAO
 * Created by 瓦力.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role>  findAllByUserId(Integer userId);
}
