package com.in28minutes1.spring.learningspringframework.game;

public class SuperContraGame implements GamingConsole {

	public void up() {
		System.out.println("SuperContra JUMP");
	}

	public void down() {
		System.out.println("SuperContra  Down into a hole");
	}

	public void left() {
		System.out.println("SuperContra stop");
	}

	public void right() {
		System.out.println("SuperContra accelerate");
	}
}
