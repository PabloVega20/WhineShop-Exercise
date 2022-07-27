package com.sinestesia.whineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinestesia.whineshop.model.Wine;

public interface WineRepository extends JpaRepository<Wine,Integer>{
	List<Wine> findAllByOrderByRatingDesc();
	List<Wine> findAllByOrderByPriceDesc();

}
