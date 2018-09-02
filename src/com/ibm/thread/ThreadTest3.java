package com.ibm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 原子性测试3
 * @author Logan
 *
 */
public class ThreadTest3 {

	public static int t = 0 ;
	
	// 使用lock进行加锁
	static Lock lock = new ReentrantLock();
	

	/**
	 * synchronized 保证数据的原子性
	 */
	public static void increase() {
		lock.lock();
		try {
			t ++;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		
		// 循环测试
		for(int i = 0 ; i < 1000 ; i++) {
			new Thread(()->{
				for(int j = 0 ; j < 1000 ; j++) {
					increase();
				}
			}).start(); ;
		}
		
		
		// 等待所有线程执行结束
		while (Thread.activeCount() > 1) {
//			System.out.println(Thread.activeCount());
			Thread.yield();
		}
		System.out.println(t);
	}
	
}
