package com.ibm.thread;

/**
 * 原子性测试1
 * @author Logan
 *
 */
public class ThreadTest {

	public static int t = 0 ;

	/**
	 * synchronized 保证数据的原子性
	 */
	public static synchronized void increase() {
		t ++;
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
