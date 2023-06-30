package com.in28minutes1.spring.learningspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacManGame implements GamingConsole{
	public void up() {
		System.out.println("PackMan JUMP");
	}
	public void down() {
		System.out.println("PackMan Down into a hole");
	}
	public void left() {
		System.out.println("PackMan stop");
	}
	public void right() {
		System.out.println("PackMan accelerate");
	}
}
