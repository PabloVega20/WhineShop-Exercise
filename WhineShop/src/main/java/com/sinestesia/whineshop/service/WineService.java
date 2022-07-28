package com.sinestesia.whineshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;

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

	public List<Wine> findAllByOrderByRatingDesc() {
		return wineRepository.findAllByOrderByRatingDesc();
	}

	public List<Wine> findAllByOrderByPriceDesc() {
		return wineRepository.findAllByOrderByPriceDesc();
	}

	public List<Wine> findAllBangs() {
		return wineRepository.findAllWines();
	}

	public Map<Integer, List<Wine>> findBestYears(int top) {
		List<Integer> years = wineRepository.findAllWineYear();
		Map<Integer, List<Wine>> mapa = new HashMap<>();
		if (years.size() < top) {
			for (int i : years) {
				List<Wine> vinos = wineRepository.findAllByYear(i);
				mapa.put(i, vinos);
			}
		} else {
			for (int i = 0; top >= i; i++) {
				List<Wine> vinos = wineRepository.findAllByYear(years.get(i));
				mapa.put(years.get(i), vinos);
			}
		}

		return mapa;
	}
}
