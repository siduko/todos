package com.todos.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.todos.webapp.models.User;
import com.todos.webapp.repositories.UserRepository;

@Controller
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String intiForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(SessionStatus status) {

		// clear the command object from the session
		status.setComplete();

		// return form success view
		return "usersuccess";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public User searchUserInfo(@RequestParam("username") String username) {
		return userRepository.findByUserName(username);
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(BindingResult result) {

		if (result.hasErrors()) {
			return "userSignup";
		}
		return "userSuccess";

	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String viewSignUp() {
		return "userSignup";
	}

	@RequestMapping(value = "add")
	public ModelAndView add() throws Exception {
		return new ModelAndView("user", "msg", "add() method");
	}

	@RequestMapping(value = "delete")
	public ModelAndView delete() throws Exception {

		return new ModelAndView("user", "msg", "delete() method");

	}

	@RequestMapping(value = "update")
	public ModelAndView update() throws Exception {

		return new ModelAndView("user", "msg", "update() method");

	}

	@RequestMapping(value = "list")
	public ModelAndView list() throws Exception {

		return new ModelAndView("user", "msg", "list() method");

	}
}
