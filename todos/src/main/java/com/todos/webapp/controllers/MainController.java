package com.todos.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value = { "/welcome**", "/" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("message", "Welcome Spring MVC");
		return "welcome";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage(Model model) {
		model.addAttribute("title", "Spring Security Hello World");
		model.addAttribute("message", "This is protected page!");
		return "admin";
	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "login";

	}
}
