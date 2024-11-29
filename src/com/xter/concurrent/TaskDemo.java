package com.xter.concurrent;

public class TaskDemo
{
	public static void main(String[] args) {
		TaskDelayer.get().reviewQueue();
		for(int i=0;i<50;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					TaskDelayer.get().addQueue(Thread.currentThread().getName()+","+System.currentTimeMillis());
				}
			}).start();
		}
	}
}
