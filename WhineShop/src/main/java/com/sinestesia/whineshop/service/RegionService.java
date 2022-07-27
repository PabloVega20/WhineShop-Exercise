package com.sinestesia.whineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinestesia.whineshop.model.Region;
import com.sinestesia.whineshop.repository.RegionRepository;

@Service
public class RegionService {
	@Autowired
	private RegionRepository regionRepository;
	
	public Region getRegionById(int id) {
		return regionRepository.findById(id).orElse(null);
	}
	
	public void saveRegion(Region region) {
		regionRepository.save(region);
	}
}
