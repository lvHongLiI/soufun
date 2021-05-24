package com.lvhongli.dao;


import com.lvhongli.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAllByOrderBySort();
}
