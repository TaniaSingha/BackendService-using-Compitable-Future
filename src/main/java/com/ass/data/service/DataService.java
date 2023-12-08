package com.ass.data.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DataService 
{

	private final ExecutorService executorService;

	
	/**
     * Initializes an ExecutorService with a fixed thread pool of 5 threads.
     */
	public DataService() 
	{
		this.executorService = Executors.newFixedThreadPool(5);
		
	}
	
	
	
	/**
     * This method calculates squares of numbers asynchronously.
     *
     * @param numbers List of integers for which squares need to be calculated.
     * @return CompletableFuture<List<Integer>> A CompletableFuture holding the list of squared numbers.
     */
	public CompletableFuture<List<Integer>> calculateSquaresAsync(List<Integer> numbers)
	{
		List<CompletableFuture<Integer>> futures = numbers.stream()
                .map(num -> CompletableFuture.supplyAsync(() -> num * num, executorService))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        CompletableFuture<List<Integer>> resultFuture = allFutures.thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        );

        resultFuture.thenAccept(result -> {
            System.out.println("Result of square operation: " + result);
        });

        return resultFuture;
	}
	
	
	 public  void shutdown() 
	 {
	        executorService.shutdown();
	    }
	
	
	
}
