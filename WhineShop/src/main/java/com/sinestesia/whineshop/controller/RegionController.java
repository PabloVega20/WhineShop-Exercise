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

import com.sinestesia.whineshop.model.Region;
import com.sinestesia.whineshop.model.Wine;
import com.sinestesia.whineshop.service.RegionService;

@RestController
@RequestMapping(value = "api")
public class RegionController {
	@Autowired
	private RegionService regionService;
	
	@GetMapping("/region/{id}")
	public ResponseEntity getRegionById(@PathVariable int id) {
		Region region = regionService.getRegionById(id);
		if(region==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(region);
	}
	

	@PostMapping("/region")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveWine(@RequestBody Region region) {
		regionService.saveRegion(region);
	}
}
