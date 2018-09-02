package com.ibm.njf;


/**
 * New features in Java 1.8 
 * 
 * @author Logan
 *
 */
public class Test {
	public static void main(String[] args) {
		MyInterface.sayBye();
		MyInterface m = new MyInterface() {
			
			@Override
			public void sayHello() {
				// TODO Auto-generated method stub
				System.out.println("Child, Hello");
			}
		};
		m.sayHello();
	}
}
