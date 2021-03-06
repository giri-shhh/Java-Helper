package com.practice.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadingUsingExecutorService {
	private static final List<Integer> h = new ArrayList<>();

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Integer> l = new ArrayList<>();
		Future<StringBuilder> submit = service.submit(() -> {
			MultiThreadingUsingExecutorService.h.add(1);
			l.add(5);
			System.out.println("Task 1 " + Thread.currentThread().getName());
			return new StringBuilder().append("Hey ");
		});

		Future<StringBuilder> submit2 = service.submit(() -> {
			h.add(2);
			l.add(6);
			System.out.println("Task 2 " + Thread.currentThread().getName());
			return new StringBuilder().append("Hello");
		});
		System.out.println(service.isShutdown());

		try {
			System.out.println(submit.get().append(submit2.get()));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		service.shutdown();
		System.out.println(h);
		System.out.println(l);
		System.out.println(Thread.currentThread().getName());
	}

}
