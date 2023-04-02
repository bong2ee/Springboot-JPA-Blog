package com.cos.blog.test;

public class People {
	private int hungryState = 50; //100
	
	public void eat() {
		hungryState += 10;
		System.out.println(hungryState);
	}
	
	public static void main(String[] args) {
		People p = new People();
		//p.hungryState = 100; X 
		p.eat();
	}
}
