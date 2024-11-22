package com.xter.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author XTER
 * 项目名称: Gateway3
 * 创建时间: 2021/3/8
 * 描述:任务防抖，以最后一次为准
 */
public class TaskDelayer {

	private static class Holder {
		static TaskDelayer INSTANCE = new TaskDelayer();
	}

	public static TaskDelayer get() {
		return Holder.INSTANCE;
	}

	private Map<String, Task> delayMap;
	private ScheduledExecutorService ses;
	private BlockingQueue<String> queue;

	private TaskDelayer() {
		delayMap = new HashMap<>();
		ses = new ScheduledThreadPoolExecutor(4);
		queue = new LinkedBlockingQueue<>(10);
	}

	public void reviewQueue(){
		ses.execute(new Runnable() {
			@Override
			public void run() {
				while (true){
					try {
						String s  = queue.take();
						System.out.println(s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void addQueue(String e){
		if (!queue.offer(e)) {
			System.out.println("----error");
		}
	}

	public void throttleLastestTask(String key, Runnable task){
		throttleLastestTask(key,task,2,TimeUnit.SECONDS);
	}

	public void throttleLastestTask(String key, Runnable task, long delay, TimeUnit unit) {
		Task value = delayMap.get(key);
		if (value == null) {
			value = new Task(task, delay, unit);
			delayMap.put(key, value);
			ses.execute(value.fetchLastestTask());
		}else{
			if(value.done){
				value.done = false;
				value.task = task;
				value.delay = delay;
				value.unit = unit;
				ses.execute(value.fetchLastestTask());
			}
		}
		value.couter.offer(0);
	}

	private final class Task {
		private Runnable task;
		private long delay;
		private TimeUnit unit;
		private SynchronousQueue<Integer> couter;
		private volatile boolean done;

		public Task(Runnable task, long delay, TimeUnit unit) {
			this.task = task;
			this.delay = delay;
			this.unit = unit;
			this.couter = new SynchronousQueue<>(true);
		}

		public Runnable fetchLastestTask() {
			return new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							if ((couter.poll(delay, unit) == null))
								break;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					done = true;
					task.run();
				}
			};
		}
	}
}
