package com.ibm.njf;

public interface MyInterface2 {


	void sayHello();
	
	default void sayHi() {
		System.out.println("Hi, in my interface 2.");
	}
	
	static void sayBye() {
		System.out.println("Bye, in my interface 2.");
	}

}
