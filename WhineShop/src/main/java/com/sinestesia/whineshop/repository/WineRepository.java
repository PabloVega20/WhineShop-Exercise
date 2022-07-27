package com.sinestesia.whineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinestesia.whineshop.model.Wine;

public interface WineRepository extends JpaRepository<Wine,Integer>{

}
