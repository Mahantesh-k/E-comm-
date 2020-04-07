package com.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.dao.Itemdao; 
import com.entity.Items;
import com.service.service;

@Controller
@RequestMapping("items")
public class Itemcontroller 
{

	@Autowired
	private service oService;

	@GetMapping("article/{id}")
	public ResponseEntity<Items> getItemsById(@PathVariable("id") Integer id) {
		Items oItems = oService.getItemsById(id);
		return new ResponseEntity<Items>(oItems, HttpStatus.OK);
	}


	@GetMapping("articles")
	public ResponseEntity<List<Items>> getAllItems() {
		List<Items> list = oService.getAllItems();
		return new ResponseEntity<List<Items>>(list, HttpStatus.OK);
	}

	@PostMapping("article")
	public ResponseEntity<Void> addItems(@RequestBody Items oItems, UriComponentsBuilder builder) {
                boolean flag = oService.addItems(oItems);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/article/{id}").buildAndExpand(oItems.getItems_id()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("article")
	public ResponseEntity<Items> updateitems(@RequestBody Items oItems) {
		oService.updateItems(oItems);
		return new ResponseEntity<Items>(oItems, HttpStatus.OK);
	}


	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		oService.deleteItems(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}










