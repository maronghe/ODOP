package com.ibm.njf;

public class Son implements MyInterface2 , MyInterface{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sayHi() {
		// TODO Auto-generated method stub
		MyInterface2.super.sayHi();
	}


}
