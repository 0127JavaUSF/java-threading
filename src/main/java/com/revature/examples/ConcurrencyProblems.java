package com.revature.examples;

import java.util.concurrent.Semaphore;

public class ConcurrencyProblems {

	public static void runExample() {
		Counter counter = new Counter();
		
		Runnable incrementor = new Incrementor(counter);
		Runnable decrementor = new Decrementor(counter);
		
		Thread a = new Thread(incrementor);
		Thread b = new Thread(decrementor);
		
		a.start();
		b.start();
		
		// To wait for a thread to complete, we can use the join method.
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(a.getState());
		System.out.println(b.getState());
		System.out.println(counter.value);
	}
}

class Counter {
//	You could also use an AtomicInteger to avoid concurrency issues
	public int value = 0;
}

class Incrementor implements Runnable {

	Counter counter;
	
	public void run() {
		for(int i = 0; i < 100000; i++) {
			synchronized(counter) {
				counter.value++;				
			}
		}
	}
	
	public Incrementor(Counter counter) {
		this.counter = counter;
	}
}

class Decrementor implements Runnable {

	Counter counter;
	
	public void run() {
		for(int i = 0; i < 100000; i++) {
			
			synchronized(counter) {
				counter.value--;				
			}
		}
	}
	
	public Decrementor(Counter counter) {
		this.counter = counter;
	}
}
