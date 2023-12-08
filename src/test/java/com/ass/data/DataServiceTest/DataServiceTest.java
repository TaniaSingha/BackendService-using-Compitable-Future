package com.ass.data.DataServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.ass.data.service.DataService;


@ExtendWith(MockitoExtension.class)
public class DataServiceTest 
{
	@Mock
	private ExecutorService executorService;
	
	@InjectMocks
	private  DataService service;
	
	
	/**
     * Initializes Mockito for each test method.
     */
	
	@BeforeEach
	void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	 /**
     * Shuts down the executor service after each test method execution.
     */
	
	@AfterEach
	public  void tearDown()
	{
		service.shutdown();
	}
	
	
	/**
     * Test case to verify the calculateSquaresAsync method in DataService.
     *
     * @throws InterruptedException If a thread is interrupted.
     * @throws ExecutionException   If an execution exception occurs.
     */
	
	@Test
	public void calculateSquaresAsyncTest() throws InterruptedException, ExecutionException
	{
		 List<Integer> inputNumbers = Arrays.asList(2, 3, 4);
	        List<Integer> squaredNumbers = Arrays.asList(4, 9, 16);


	        CompletableFuture<List<Integer>> resultFuture = service.calculateSquaresAsync(inputNumbers);

	
	        List<Integer> result = resultFuture.get();

	  
	        assertEquals(squaredNumbers, result);
		
		
	
		
	}

}
