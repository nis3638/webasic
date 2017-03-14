package com.vows.test.thread;

public class ThreadClient {
	public static void main(String args[]){
		//TicketThreads tt1 = new TicketThreads("salorA");
		//TicketThreads tt2 = new TicketThreads("salorB");
		//TicketThreads tt3 = new TicketThreads("salorC");
		TicketRunnable tt1 = new TicketRunnable();

		Thread th1 = new Thread(tt1,"A");
		Thread th2 = new Thread(tt1,"B");
		Thread th3 = new Thread(tt1,"C");

		th1.start();
		th2.start();
		th3.start();
		for(int a=0;a<5;a++){
			System.out.println("main thread"+a);
		}

	}
}
