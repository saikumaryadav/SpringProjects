package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount = 0;
	static {
		users.add(new User(++userCount, "adam", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "eve", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "jim", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "ram", LocalDate.now().minusYears(30)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public void deleteUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
