package com.revature.examples.threads;

/*
 * Runnable is an example of a functional interface
 * meaning that it has exactly one abstract method
 * 
 * Note: Marker interface is any interface with no
 * abstract methods.
 */
public class MyRunnable implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("From Runnable on thread: " + Thread.currentThread().getName());
	}
	
	
}
