package com.vows.test.thread;

public class TicketRunnable implements Runnable {
	private int ticketsConts = 5;

	//private String name;

	

	@Override
	public void run() {
		while(ticketsConts>0){ 
			ticketsConts--;
			System.out.println(Thread.currentThread().getName()+"窗口卖了1章票");
		}
	}

}
