package com.ibm.njf;


public interface MyInterface {

	void sayHello();
	
	default void sayHi() {
		System.out.println("Hi, in my interface.");
	}
	
	static void sayBye() {
		System.out.println("Bye, in my interface.");
	}
}
