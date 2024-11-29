package com.xter.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DealBus {

	private static class Holder{
		static final DealBus INSTANCE = new DealBus();
	}

	public static DealBus get(){
		return Holder.INSTANCE;
	}

	private BlockingQueue<String> queue;
	private AtomicInteger counter;

	public DealBus(){
		queue = new LinkedBlockingQueue<>(50);
		counter = new AtomicInteger(0);
	}

	public synchronized void enqueueString(String test) throws InterruptedException {
		System.out.println(queue.size());
		queue.put(test);
	}

	public void startWork(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					try {
						String test = queue.take();
						System.out.println(test);
						counter.incrementAndGet();
						if(queue.isEmpty()){
							System.out.println(counter.get());
						}
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();
	}
}
