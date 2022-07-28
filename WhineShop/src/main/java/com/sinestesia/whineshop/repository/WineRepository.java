package com.sinestesia.whineshop.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinestesia.whineshop.model.Wine;

public interface WineRepository extends JpaRepository<Wine,Integer>{
	List<Wine> findAllByOrderByRatingDesc();
	List<Wine> findAllByOrderByPriceDesc();
	
	@Query("select w from Wine w  group by w.price order by w.rating desc")
	List<Wine> findAllWines();
	
	@Query("SELECT distinct w.year FROM Wine w ORDER BY w.rating desc")
	List<Integer> findAllWineYear();
	
	List<Wine> findAllByYear(int year);
	
//	@Query("SELECT w.year, w FROM Wine as w WHERE year>0 GROUP BY year ORDER BY rating desc")
//	List<Map<Integer,Wine>> findAllByYearAndRating();
}
