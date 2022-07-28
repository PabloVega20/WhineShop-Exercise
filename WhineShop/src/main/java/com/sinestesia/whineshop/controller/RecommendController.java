package com.sinestesia.whineshop.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.service.WineService;
import com.sinestesia.whineshop.service.WineryService;

@RestController
@RequestMapping (value = "api")
public class RecommendController {

	@Autowired
	private WineService wineService;
	
	@GetMapping("/recommend/best")
	public ResponseEntity findAllByOrderByRatingDesc(@RequestParam int top) {
		List<Wine> vinos = wineService.findAllByOrderByRatingDesc();
		if(vinos==null) {
			return ResponseEntity.notFound().build();
		}
		int maxVinos=vinos.size();
		if(maxVinos<top)
			return ResponseEntity.ok(vinos);
		else
			return ResponseEntity.ok(vinos.subList(0, top));
	}
	
	@GetMapping("/recommend/expensive")
	public ResponseEntity findAllByOrderByPriceDesc(@RequestParam int top) {
		List<Wine> vinos = wineService.findAllByOrderByPriceDesc();
		if(vinos==null) {
			return ResponseEntity.notFound().build();
		}
		int maxVinos=vinos.size();
		if(maxVinos<top)
			return ResponseEntity.ok(vinos);
		else
			return ResponseEntity.ok(vinos.subList(0, top));
	}
	
	@GetMapping("/recommend/bang")
	public ResponseEntity findAllBang(@RequestParam int top) {
		List<Wine> vinos = wineService.findAllBangs();
		if(vinos==null) {
			return ResponseEntity.notFound().build();
		}
		int maxVinos=vinos.size();
		if(maxVinos<top)
			return ResponseEntity.ok(vinos);
		else
			return ResponseEntity.ok(vinos.subList(0, top));
	}
	
	@GetMapping("/recommend/vintage")
	public ResponseEntity findBestYears(@RequestParam int top) {
		Map<Integer, List<Wine>> vinos = wineService.findBestYears(top);
		if(vinos==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vinos);
	}
}
