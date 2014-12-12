package com.todos.webapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.todos.webapp.models.User;

@Controller
@RequestMapping(value = "user")
public class UserController {

	ApplicationContext ctx = new GenericXmlApplicationContext(
			"SpringConfig.xml");
	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");

	@RequestMapping(method = RequestMethod.GET)
	public String intiForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("user") User user,
			BindingResult result, SessionStatus status) {

		// clear the command object from the session
		status.setComplete();

		// return form success view
		return "usersuccess";

	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("user") User user,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors())
			return "userSignup";

		return "userSuccess";

	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String viewSignUp() {
		return "userSignup";
	}

	@RequestMapping(value = "add")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("user", "msg", "add() method");
	}

	@RequestMapping(value = "delete")
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("user", "msg", "delete() method");

	}

	@RequestMapping(value = "update")
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("user", "msg", "update() method");

	}

	@RequestMapping(value = "list")
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("user", "msg", "list() method");

	}
}
