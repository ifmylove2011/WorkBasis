package com.xter.threadpool;

import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		Set<Integer> threadSet = new ConcurrentSkipListSet<>();
		ReentrantLock lock = new ReentrantLock(true);
		int n = 30;
		Runnable[] tasks = new Runnable[n];
		for (int i = 0; i < tasks.length; i++) {
			final String taskExecutionFlag = "task" + (i + 1);
			tasks[i] = new Runnable() {

				@Override
				public String toString() {
					return taskExecutionFlag;
				}

				@Override
				public void run() {
					try {
						lock.lock();
						int threadHashCode = Thread.currentThread().hashCode();
						threadSet.add(threadHashCode);
						System.out.println("threadHashCode = " + threadHashCode + ", task =" + taskExecutionFlag + ", threadSize :" + threadSet.size());
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			};
		}

		testCustomThreadPool(tasks);
	}

	public static void testCustomThreadPool(Runnable[] tasks) {
		ExecutorService executor = new ThreadPoolExecutor(2, 5, 20, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new CustomRejectHandler());
		for (int i = 0; i < tasks.length; i++) {
			executor.execute(tasks[i]);
		}
	}

	static class CustomRejectHandler implements RejectedExecutionHandler {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println(r.toString() + " is rejected");
		}
	}
}