package com.vows.test.thread;

public class TicketThreads extends Thread {
	private int ticketsConts = 5;

	private String name;

	public TicketThreads( String name ){
		this.name = name;
	}

	@Override
	public void run(){
		
		while(ticketsConts>0){ 
			ticketsConts--;
			System.out.println(name+"窗口卖了1章票");
		}
	}
}
