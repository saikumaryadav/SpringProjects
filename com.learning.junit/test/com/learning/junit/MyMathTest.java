package com.learning.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyMathTest {

	private MyMath myMath = new MyMath();

	@Test
	public void test() {
		assertEquals(6, myMath.calculateSum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void testWithEmpty() {
		assertEquals(0, myMath.calculateSum(new int[] {}));
	}

}
