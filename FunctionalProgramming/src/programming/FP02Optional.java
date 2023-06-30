package programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class FP02Optional {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "banana", "mango","bingo");
		System.out.println(fruits);
		Map map = new HashMap<>();
		Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
		Optional<String> optional = fruits.stream().filter(predicate).findAny();
		System.out.println(optional);
		System.out.println(optional.empty());
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
	}

}
