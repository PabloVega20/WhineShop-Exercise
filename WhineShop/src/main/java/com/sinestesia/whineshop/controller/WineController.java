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
import com.sinestesia.whineshop.service.WineService;

@RestController
@RequestMapping(value = "api")
public class WineController {
	@Autowired
	private WineService wineService;
	
	@GetMapping("/wine/{id}")
	public ResponseEntity getWineById(@PathVariable int id) {
		Wine vino = wineService.getWineById(id);
		if(vino==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vino);
	}
	
	
	@PostMapping("/wine")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveWine(@RequestBody Wine vino) {
		wineService.saveWine(vino);
	}
}
