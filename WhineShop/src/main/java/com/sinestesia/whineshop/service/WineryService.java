package com.sinestesia.whineshop.service;

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
	
	public Winery getWineryById(int id) {
		return wineryRepository.findById(id).orElse(null);
	}
	
	public void saveWinery(Winery bodega) {
		wineryRepository.save(bodega);
	}

}
