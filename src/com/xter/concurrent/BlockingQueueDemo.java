package com.xter.concurrent;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(50);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					try {
						String s  = blockingQueue.take();
						System.out.println(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		for(int i=0;i<60;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true){
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(!blockingQueue.offer(Thread.currentThread().getName()+","+System.currentTimeMillis())){
							System.out.println("----error");
						}
					}
				}
			}).start();
		}
	}
}
