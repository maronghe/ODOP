package com.ibm.thread;

/**
 * ThreadLocalTest
 * @author Logan
 */
public class ThreadLocalTest {

	// long Thread Local
	private ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	// string Thread Local
	private ThreadLocal<String> stringLocal = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException {
		final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
		// 设置值
		threadLocalTest.set();
		System.out.println("===1===");
		System.out.println(threadLocalTest.getLongLocal().get());
		System.out.println(threadLocalTest.getStringLocal().get());

		// 创建线程
		Thread thread = new Thread(()->{
			// 当这里调用了set方法，进一步调用了ThreadLocal的set方法是，
			// 会将ThreadLocal变量存储到该线程的ThreadLocalMap类型的成员变量threadLocals中，
			// 注意的是这个threadLocals变量是Thread线程的一个变量，而不是ThreadLocal类的变量。
			threadLocalTest.set();
			System.out.println("===2===");
			System.out.println(threadLocalTest.getLongLocal().get());
			System.out.println(threadLocalTest.getStringLocal().get());

		});
		thread.start();
		thread.join();// 强行加入
		System.out.println("===3===");
		System.out.println(threadLocalTest.getLongLocal().get());
		System.out.println(threadLocalTest.getStringLocal().get());

	}

	/**
	 *  设置线程的Id 和 Name
	 */
	private void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}

	public ThreadLocal<Long> getLongLocal() {
		return longLocal;
	}

	public ThreadLocal<String> getStringLocal() {
		return stringLocal;
	}

}