package com.example.core.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorFrameworkTest {

    //Topics can be covered for learn Executor Framework
    //1. Executor interface
    //2. ExecutorService interface
    //3. Executors class
//Need to understand thread factory
    @Test
    void testExecutorFramework() throws ExecutionException, InterruptedException {
        Executor executor = command -> new Thread(command).start();
        executor.execute(() -> System.out.println("Hello this is basic executor"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> System.out.println("This is from fixed thread pool executor service"));

        ExecutorService executorServiceSubmit = Executors.newFixedThreadPool(3);
        Future<Double> doubleFuture = executorServiceSubmit.submit(() -> randomNumberGenerator());
        System.out.println("Waiting for the result");
        System.out.println("value from future: "+doubleFuture.get());
        List<Future<Double>>   futureList = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            Future<Double> doubleFuture1 = executorServiceSubmit.submit(this :: randomNumberGenerator);
            futureList.add(doubleFuture1);
        }

        while(true){
            if(isCompleted(futureList)){
                System.out.println("All tasks completed");
                break;
            }else{
                System.out.println("Waiting for all tasks to complete");
                Thread.sleep(1000);
            }
        }

    }

    private static boolean isCompleted(List<Future<Double>> futureList) {
        return futureList.stream().allMatch(Future::isDone);
    }

    Double randomNumberGenerator() throws InterruptedException {
        System.out.println("randomNumberGenerator called");
        Thread.sleep(10000);
        return Math.random();
    }
}
