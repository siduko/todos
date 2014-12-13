package com.todos.webapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
//	private static final Logger logger = Logger.getLogger(UserController.class);

//	ApplicationContext ctx = new GenericXmlApplicationContext(
//			"spring-data-config.xml");
//	MongoOperations mongoOperation = (MongoOperations) ctx
//			.getBean("mongoTemplate");
//	
//	@Autowired
//	UserRepository userRepository = ctx.getBean("userRepository",UserRepository.class);
	@Autowired
	UserRepository userRepository;

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

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody User searchUserInfo(@RequestParam("username") String username,
			Model model) {
		//Query searchUserQuery = new Query(Criteria.where("_id").is(username));
		//User user = mongoOperation.findOne(searchUserQuery, User.class);
		User user = userRepository.findByUserName(username);
		return user;
		//return null;
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
