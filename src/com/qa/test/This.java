package com.qa.test;

public class This {

	String s;
	int i;
	
	public static void main(String[] args) {
		This t=new This();
	
		
	
		System.out.println(t.s);
		System.out.println(t.i);
		System.out.println(t.name());
		System.out.println(t.m1());
	}
	public This() {
		this.i=100;
		this.s="that";
		this.name();
		this.m1();
	}
	public String name() {
		System.out.println("name method");
		return "jimmy";
	}
	public String m1() {
		this.name();
		return "gyanesh";
	}
}
