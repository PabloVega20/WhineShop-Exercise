package com.sinestesia.whineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinestesia.whineshop.model.WineType;
import com.sinestesia.whineshop.repository.WineTypeRepository;

@Service
public class WineTypeService {
	@Autowired
	private WineTypeRepository wineTypeRepository;
	
	
	public WineType getWineTypeById(int id) {
		return wineTypeRepository.findById(id).orElse(null);
	}
	
	public void saveWineType(WineType tipo) {
		wineTypeRepository.save(tipo);
	}
}
