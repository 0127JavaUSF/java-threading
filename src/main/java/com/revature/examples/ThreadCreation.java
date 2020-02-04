package com.revature.examples;

import com.revature.examples.threads.MyRunnable;

public class ThreadCreation {
	public static void runExample() {
		/*
		 * Creation of Threads:
		 * 1. Extend the Thread class
		 * 2. Implement the Runnable interface
		 * 
		 * Encouraged to implement the interface because it exposes only the
		 * functionality that you really need to work with in the vast majority
		 * of cases.
		 * 
		 * Notes on multi-threaded applications: Taking an application from single threaded
		 * to multithreaded, introduces a lot of complexity. This complexity may be 
		 * difficult to manage.  
		 */
//		MyThread myThread = new MyThread();
		Runnable myRunnable = new MyRunnable();
		Thread myThread = new Thread(myRunnable);
		
		System.out.println(Thread.currentThread().getName());

		// This method will first create a new thread at the OS level and then
		// attempt to run the run method as the thread becomes active
		myThread.start();
		System.out.println(myThread.getState());
		
		// Where will the thread print within this loop? We can't know beforehand.
		// We don't know. We have no way of determining based on the current implementation.
		// And we will likely have different results between runs and between systems.
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}
