package com.revature.examples.threads;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Running from thread: " + Thread.currentThread().getName());
	}
	
	
}
