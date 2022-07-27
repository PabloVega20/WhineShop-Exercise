package com.sinestesia.whineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

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
	
	
	@GetMapping("/winery/{id}")
	public ResponseEntity getWineryById(@PathVariable int id) {
		Winery bodega = wineryService.getWineryById(id);
		if(bodega==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bodega);
	}
	

	@PostMapping("/winery")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveWine(@RequestBody Winery bodega) {
		wineryService.saveWinery(bodega);
	}
	
}
