package com.sinestesia.whineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.model.WineType;
import com.sinestesia.whineshop.service.WineTypeService;

@RestController
@RequestMapping(value = "api")
public class WineTypeController {
	@Autowired
	private WineTypeService wineTypeService;
	
	@GetMapping("/type/{id}")
	public ResponseEntity getWineTypeById(@PathVariable int id) {
		WineType wineType = wineTypeService.getWineTypeById(id);
		if(wineType==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(wineType);
	}
	
	@PostMapping("/type")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveWine(@RequestBody WineType tipo) {
		wineTypeService.saveWineType(tipo);
	}
}
