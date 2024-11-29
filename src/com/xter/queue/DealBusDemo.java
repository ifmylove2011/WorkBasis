package com.xter.queue;

import java.util.concurrent.TimeUnit;

public class DealBusDemo {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				DealBus.get().startWork();
			}
		}).start();
		for (int i=0;i<10;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<20;j++){
						try {
							DealBus.get().enqueueString(Thread.currentThread().getName()+"--"+j);
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
}
