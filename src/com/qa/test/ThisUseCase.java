package com.qa.test;

public class ThisUseCase {

	String name;//null
	int i;
	
	public static void main(String[] args) {
		ThisUseCase t=new ThisUseCase("gyanesh",10);
		System.out.println(t.name);
		System.out.println(t.i);
	}
	public ThisUseCase(String name,int i) {
		this.name="nimisha";
		this.i=20;
		this.m1();
		
	}
	public void m1() {
		System.out.println("m1 method");
	}
}
