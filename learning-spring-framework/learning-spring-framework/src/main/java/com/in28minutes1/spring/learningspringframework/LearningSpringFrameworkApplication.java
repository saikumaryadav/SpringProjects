package com.in28minutes1.spring.learningspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes1.spring.learningspringframework.enterprise.example.web.MyController;
import com.in28minutes1.spring.learningspringframework.game.GameRunner;

@SpringBootApplication
public class LearningSpringFrameworkApplication {

	public static void main(String[] args) {
		// SpringApplication.run(LearningSpringFrameworkApplication.class, args);
		/**
		 * Achieving loose coupling by creating an GamingConsole interface and make
		 * default methods in it and implements it by other classes
		 */
		// MarioGame game = new MarioGame();
		// GamingConsole game = new MarioGame(); //1
		// GameRunner runner = new GameRunner(game); //2

		/** runner object is depending on the game object */
		ConfigurableApplicationContext context = SpringApplication.run(LearningSpringFrameworkApplication.class, args);
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		MyController controller = context.getBean(MyController.class);
		System.out.println(controller.returnBusinessValue());

	}

}
