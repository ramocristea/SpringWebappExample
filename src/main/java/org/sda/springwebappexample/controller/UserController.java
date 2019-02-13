package org.sda.springwebappexample.controller;

import org.sda.springwebappexample.model.Address;
import org.sda.springwebappexample.model.User;
import org.sda.springwebappexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

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
	public String getUserById(@PathVariable(value = "id") int id, Model model) {
		System.out.println("The id we received is: " + id);
		User user = new User();
		user.setId(id);
		user.setFirstName("mihai");
		user.setLastName("alexandru");
		user.setPhoneNo("123456");

		model.addAttribute("user1", user);

		return "userPage";
	}

	@RequestMapping(value = "/users/{id}/addresses", method = RequestMethod.GET)
	public String getAddressesForUserId(Model model, @PathVariable(value = "id") int id) {
		User user = userService.getUserById(id);
		model.addAttribute("addresses", user.getAddresses());

		return "userAddressPage";
	}

	@RequestMapping(value = "/users/{id}/adresses/{addressId}", method = RequestMethod.GET)
	public String getAddressesForUserId(Model model, @PathVariable(value = "id") int id,
			@PathVariable(value = "addressId") int addressId) {
		User user = userService.getUserById(id);
		Address address = userService.getAdressById(user.getAddresses(), addressId);
		model.addAttribute("address", address);

		return "address";
	}

	@RequestMapping(value = "/usersWithQueryParam", method = RequestMethod.GET)
	public String getUserWithQueryParams(Model model, @RequestParam(value = "firstName") String firstName) {
		if (firstName.equals("Ramona")) {
			User firstUser = new User();
			firstUser.setFirstName("Ramona");
			firstUser.setLastName("Cristea");
			firstUser.setPhoneNo("123");
			model.addAttribute("user1", firstUser);
		} else {

			User secondUser = new User();
			secondUser.setFirstName("Ion");
			secondUser.setLastName("Mihai");
			secondUser.setPhoneNo("456");

			model.addAttribute("user2", secondUser);
		}

		return "userPage";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String getUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}

	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String saveUser(Model model, @ModelAttribute("user") User user) {
		model.addAttribute("user1", user);
		
		return "userPage";
		
	}
}
