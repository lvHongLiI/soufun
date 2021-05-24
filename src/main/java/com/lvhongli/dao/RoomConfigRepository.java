package com.lvhongli.dao;

import com.lvhongli.model.RoomConfig;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomConfigRepository extends JpaRepository<RoomConfig, Long> {


    List<RoomConfig> findAllByTypeOrderBySort(String   type);
}
