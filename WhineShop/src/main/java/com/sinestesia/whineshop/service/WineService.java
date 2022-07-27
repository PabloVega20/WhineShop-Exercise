package com.sinestesia.whineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.repository.WineRepository;

@Service
public class WineService {
	@Autowired
	private WineRepository wineRepository;
	
	public Wine getWineById(int id) {
		return wineRepository.findById(id).orElse(null);
	}
	
	public void saveWine(Wine vino) {
		wineRepository.save(vino);
	}
}
