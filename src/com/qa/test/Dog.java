package com.qa.test;

public class Dog extends Animal {

	String color="black";
	
	public static void main(String[] args) {
		 
		Dog d=new Dog();
		d.print();
		
	}
	public void print() {
		System.out.println(color);
		System.out.println(super.color);
	}
}
