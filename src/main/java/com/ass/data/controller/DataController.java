package com.ass.data.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ass.data.service.DataService;


/**
 * Handles HTTP requests related to data calculations asynchronously.
 * @author Tania Singha
 */


@RestController
public class DataController 
{
	@Autowired
	private  DataService service;
	
	
	  /**
     * Endpoint to calculate squares of numbers asynchronously.
     *
     * @param It takes list of integers for which squares need to be calculated.
     * @return CompletableFuture<List<Integer>> A CompletableFuture holding the list of squared numbers.
     */
	
	@RequestMapping("/calculateSquaresAsync")
	public CompletableFuture<List<Integer>> calculateSquaresAsync(@RequestBody List<Integer> numbers)
	{
		return service.calculateSquaresAsync(numbers);
	}

}
