package org.sda.springwebappexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	@RequestMapping(value="/myFirstMessage", method= RequestMethod.GET)
	public String getFirstMessage(Model model) {
		String message = "this is my first web application";
		model.addAttribute("msg", message);
		return "firstMessage";
	}
}
