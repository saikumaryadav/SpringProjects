package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResources {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user  = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id not found: "+id );
		}
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {

		User savedUser = userDaoService.save(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
 
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userDaoService.deleteUserById(id);
		
	}

}
