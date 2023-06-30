package programming;

import java.util.Arrays;
import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		// printAllNumbersInListFunctional(Arrays.asList(1, 2, 3, 2, 1, 5, 64, 23, 21,
		// 3, 0));
		printEvenNumbersInListFunctional(Arrays.asList(1, 2, 3, 2, 1, 5, 64, 23, 21, 3, 0));
	}

	public static void printing(int number) {
		System.out.println(number);
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// numbers.stream().forEach(FP01Functional::printing);
		numbers.stream().forEach(System.out::println);
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
				// .filter(FP01Functional::isEven) // filter even numbers from stream
				.filter(number -> number % 2 == 0) // Lambda expression
				.forEach(System.out::println);
	}
}
