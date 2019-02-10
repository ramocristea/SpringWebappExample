package org.sda.springwebappexample.controller;

import org.sda.springwebappexample.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUser(Model model) {
		User firstUser = new User();
		firstUser.setFirstName("Ramona");
		firstUser.setLastName("Cristea");
		firstUser.setPhoneNo("123");

		User secondUser = new User();
		secondUser.setFirstName("Ion");
		secondUser.setLastName("Mihai");
		secondUser.setPhoneNo("456");

		model.addAttribute("user1", firstUser);
		model.addAttribute("user2", secondUser);

		return "userPage";
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String getUserById(@PathVariable(value="id") int id, Model model) {
		System.out.println("The id we received is: " + id);
		User user = new User();
		user.setId(id);
		user.setFirstName("mihai");
		user.setLastName("alexandru");
		user.setPhoneNo("123456");
		
		model.addAttribute("user1", user);
		
		return "userPage";
	}

}
