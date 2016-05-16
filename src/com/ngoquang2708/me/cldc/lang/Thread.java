package com.ngoquang2708.me.cldc.lang;

import java.util.Hashtable;

public class Thread implements Runnable {

	public static final int MAX_PRIORITY = java.lang.Thread.MAX_PRIORITY;
	public static final int MIN_PRIORITY = java.lang.Thread.MIN_PRIORITY;
	public static final int NORM_PRIORITY = java.lang.Thread.NORM_PRIORITY;

	static final Hashtable map = new Hashtable();

	final java.lang.Thread nativeThread;
	final Runnable runnable;

	public Thread() {
		nativeThread = new java.lang.Thread(new RunnableForwarder());
		runnable = null;
		map.put(nativeThread, this);
	}

	public Thread(String name) {
		nativeThread = new java.lang.Thread(new RunnableForwarder(), name);
		runnable = null;
		map.put(nativeThread, this);
	}

	public Thread(Runnable runnable) {
		this.nativeThread = new java.lang.Thread(new RunnableForwarder());
		this.runnable = runnable;
		map.put(nativeThread, this);
	}

	public Thread(Runnable runnable, String name) {
		this.nativeThread = new java.lang.Thread(new RunnableForwarder(), name);
		this.runnable = runnable;
		map.put(nativeThread, this);
	}

	public void interrupt() {
		nativeThread.interrupt();
	}

	public final String toString() {
		return nativeThread.toString();
	}

	public final String getName() {
		return nativeThread.getName();
	}

	public final int getPriority() {
		return nativeThread.getPriority();
	}

	public final void setPriority(int newPriority) {
		nativeThread.setPriority(newPriority);
	}

	public final boolean isAlive() {
		return nativeThread.isAlive();
	}

	public synchronized final void join() throws InterruptedException {
		nativeThread.join();
	}

	public synchronized void start() {
		nativeThread.start();
	}

	public void run() {
		if (runnable != null)
			runnable.run();
	}

	public static Thread currentThread() {
		java.lang.Thread currentNativeThread = java.lang.Thread.currentThread();
		Thread currentThread;
		if ((currentThread = (Thread) map.get(currentNativeThread)) == null) {
			synchronized (map) {
				if ((currentThread = (Thread) map.get(currentNativeThread)) == null) {
					currentThread = new Thread(currentNativeThread);
					map.put(currentNativeThread, currentThread);
				}
			}
		}
		return currentThread;
	}

	public static int activeCount() {
		return java.lang.Thread.activeCount();
	}

	public static void sleep(long millis) throws InterruptedException {
		java.lang.Thread.sleep(millis);
	}

	public static void yield() {
		java.lang.Thread.yield();
	}

	private class RunnableForwarder implements Runnable {

		public void run() {
			try {
				Thread.this.run();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				map.remove(nativeThread);
			}
		}
	}
}