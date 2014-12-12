package com.todos.webapp.controllers;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todos.webapp.models.User;

@Controller
public class MainController {

	ApplicationContext ctx = new GenericXmlApplicationContext(
			"SpringConfig.xml");
	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");
	
	@RequestMapping(value = { "/welcome**", "/" }, method = RequestMethod.GET)
	public String welcomeView(Model model) {
		model.addAttribute("message", "Welcome Spring MVC");
		return "welcome";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminView(Model model) {
		model.addAttribute("title", "Spring Security Hello World");
		model.addAttribute("message", "This is protected page!");
		return "admin";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerView(Model model) {
		model.addAttribute("title", "Spring Security Hello World");
		model.addAttribute("message", "This is protected page!");
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") @Valid User newUser,BindingResult result, Model model) {
		if(result.hasErrors()){
			model.addAttribute("msg","Check your input, because it not correct");
			model.addAttribute("error","Error");
			System.out.println("");
			return "register";
		}
		else
		{
			//try{
				mongoOperation.insert(newUser);
			//}catch(Exception e)
			//{
			//	model.addAttribute("msg",e.getMessage());
			//	model.addAttribute("error","Error");
			//	return "register";
			//}
		}
		Query searchUserByUserNameQuery = new Query(Criteria.where("_id").is(newUser.getUserName()));
		model.addAttribute("user",mongoOperation.findOne(searchUserByUserNameQuery, User.class));
		return "user";
	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView(
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
