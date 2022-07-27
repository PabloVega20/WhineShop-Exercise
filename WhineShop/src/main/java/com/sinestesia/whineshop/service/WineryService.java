package com.sinestesia.whineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinestesia.whineshop.model.Region;
import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.model.WineType;
import com.sinestesia.whineshop.model.Winery;
import com.sinestesia.whineshop.repository.RegionRepository;
import com.sinestesia.whineshop.repository.WineRepository;
import com.sinestesia.whineshop.repository.WineTypeRepository;
import com.sinestesia.whineshop.repository.WineryRepository;

@Service
public class WineryService {
	@Autowired
	private WineryRepository wineryRepository;
	
	@Autowired
	private WineRepository wineRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private WineTypeRepository wineTypeRepository;
	
	public Winery getWineryById(int id) {
		return wineryRepository.findById(id).get();
	}
	
	public Wine getWineById(int id) {
		return wineRepository.findById(id).get();
	}
	
	public List<Wine> findAllByOrderByRatingDesc() {
		return wineRepository.findAllByOrderByRatingDesc();
	}
	
	public List<Wine> findAllByOrderByPriceDesc() {
		return wineRepository.findAllByOrderByPriceDesc();
	}
	
	public Region getRegionById(int id) {
		return regionRepository.findById(id).get();
	}
	
	public WineType getWineTypeById(int id) {
		return wineTypeRepository.findById(id).get();
	}
	
	
}
