package com.ibm.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;


/**
 * 
 * 原子性测试2
 * @author Logan
 *
 */
public class ThreadTest2 {

	// 使用AtomicInteger
	static AtomicInteger atomicInteger = new AtomicInteger();

	
	/**
	 * synchronized 保证数据的原子性
	 */
	public static void increase() {
		// 与i++一个道理
		atomicInteger.getAndIncrement();
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
		System.out.println(atomicInteger);
		
		AtomicIntegerArray array = new AtomicIntegerArray(10);
		array.set(1, 10);
		System.out.println(array.get(1));;
		
	}

}
