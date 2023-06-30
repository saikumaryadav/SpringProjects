package com.in28minutes1.spring.learningspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("JUMP");
	}
	public void down() {
		System.out.println("Down into a hole");
	}
	public void left() {
		System.out.println("stop");
	}
	public void right() {
		System.out.println("accelerate");
	}
}
