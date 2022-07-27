package com.sinestesia.whineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinestesia.whineshop.model.Region;
import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.model.WineType;
import com.sinestesia.whineshop.model.Winery;
import com.sinestesia.whineshop.service.WineryService;

@RestController
@RequestMapping (value = "api")
public class WineryController {	
	@Autowired
	private WineryService wineryService;
	
	@GetMapping("/wine/{id}")
	public ResponseEntity getWineById(@PathVariable int id) {
		Wine vino = wineryService.getWineById(id);
		if(vino==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vino);
	}
	
	@GetMapping("/winery/{id}")
	public ResponseEntity getWineryById(@PathVariable int id) {
		Winery bodega = wineryService.getWineryById(id);
		if(bodega==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bodega);
	}
	
	@GetMapping("/region/{id}")
	public ResponseEntity getRegionById(@PathVariable int id) {
		Region region = wineryService.getRegionById(id);
		if(region==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(region);
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity getWineTypeById(@PathVariable int id) {
		WineType wineType = wineryService.getWineTypeById(id);
		if(wineType==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(wineType);
	}
}
