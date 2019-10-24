package com.springboot.messagingappboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.messagingappboot.PopulateInitialData;
import com.springboot.messagingappboot.config.roleConstants;
import com.springboot.messagingappboot.dto.Credentials;
import com.springboot.messagingappboot.dto.Message;
import com.springboot.messagingappboot.dto.User;
import com.springboot.messagingappboot.service.CredentialsService;
import com.springboot.messagingappboot.service.LoginService;
import com.springboot.messagingappboot.service.MessageService;
import com.springboot.messagingappboot.service.UserService;

@Controller
public class ApplicationController {

	@Autowired
	LoginService loginService;
	@Autowired
	MessageService messageService;
	@Autowired
	UserService userService;
	@Autowired
	CredentialsService credentialsService;

	@RequestMapping(path = "/profile")
	public ModelAndView getAdmin(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		User user;
		
		// Getting by id again, to show any updated messages in this session.
		if(session.getAttribute("user") != null) {
			String uId = ((User) session.getAttribute("user")).getId();
			user = userService.getById(uId);
			session.setAttribute("user", user);
			System.out.println(uId + "<<<<<<<<<<<<<<<");
		}else {
			user = (User)session.getAttribute("user");
			session.removeAttribute("register");
		}
		
		mv.setViewName(loginService.getView(user.getRole()) + ".jsp");
		System.out.println("HERE!!!!");
		return mv;
	}

	@PostMapping(path = "/validate")
	public String validate(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpSession session, HttpServletResponse response)
			throws IOException {
		if (session.getAttribute("register") != null) {
			if(loginService.userExists(username)) {
				System.out.println("Username exists");
				session.setAttribute("register", -1);
				response.sendRedirect("/register");
			}else {
				System.out.println("Then why u here?");
				Credentials credentials = new Credentials();
				credentials.setUsername(username);
				credentials.setPassword(password);
				credentialsService.add(credentials);
				User newUser = new User();
				newUser.setCredentials(credentialsService.getByUsername(username));
				newUser.setRole(roleConstants.ROLE_USER);
				userService.add(newUser);
				session.setAttribute("user", newUser);
				session.setAttribute("loggedIn", 1);
				response.sendRedirect("/profile");
			}
			
		}else {
			User user = loginService.getUser(username);

			if (user == null) {
				session.setAttribute("loggedIn", -2);
				response.sendRedirect("/login");
			} else {
				if (user.getCredentials().getUsername().equals(username)
						&& user.getCredentials().getPassword().equals(password)) {
					session.setAttribute("user", user);
					session.setAttribute("loggedIn", 1);
					response.sendRedirect("/profile");
				} else {
					session.setAttribute("loggedIn", -1);
					response.sendRedirect("/login");
				}
			}
		}
		// fetch user
		
		return null;
	}

	@RequestMapping(path = "/composeMessage")
	public ModelAndView compose(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("users") == null) {
			session.setAttribute("users", userService.getall());
		}
		mv.setViewName("composeMessage.jsp");

		return mv;
	}

	@RequestMapping(path = "/messageSent")
	public ModelAndView messsageSent(@RequestParam(value = "To") String receiver,
			@RequestParam(value = "Message") String messageBody, @RequestParam(value = "Title") String title,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();

		Message message = new Message();
		message.setTitle(title);
		message.setContent(messageBody);
		message.setReceiver(userService.getByCredentials(credentialsService.getByUsername(receiver)));
		message.setSender((User) session.getAttribute("user"));
		messageService.add(message);

		mv.setViewName("messageSent.jsp");

		return mv;
	}

	@RequestMapping(path = "/login")
	public String loginPage(HttpSession session, HttpServletResponse response) throws IOException {
		
//		if(session.getAttribute("running") == null) {
//			PopulateInitialData.populateData();
//			session.setAttribute("running", true);
//		}
		if (session.getAttribute("loggedIn") == null) {
			session.setAttribute("loggedIn", 0);
		} else {
			if ((int) session.getAttribute("loggedIn") == 1) {
				response.sendRedirect("/profile");
			}
		}
		
		if(session.getAttribute("register") != null) {
			session.removeAttribute("register");
		}
		
		return "login.jsp";
	}

	@RequestMapping(path = "/logout")
	public String logout(HttpSession session, HttpServletResponse response) throws IOException {
//		session.setAttribute("logout", 1);
//		session.setAttribute("loggedIn", 0);
		session.invalidate();
		session.setAttribute("running", true);
//		return "login.jsp";
		response.sendRedirect("/login");
		return null;
	}

	@RequestMapping(path = "/seeMessages")
	public ModelAndView seeMessages() {
		ModelAndView mv = new ModelAndView();
		List<Message> messages = messageService.getall();
		for (Message msg : messages) {
			System.out.println(msg);
		}
		mv.addObject("messages", messages);
		mv.setViewName("allMessages.jsp");

		return mv;
	}
	
	@RequestMapping(path = "/seeUsers")
	public ModelAndView seeUsers() {
		ModelAndView mv = new ModelAndView();
		List<User> users = userService.getall();
		mv.addObject("users", users);
		mv.setViewName("allUsers.jsp");

		return mv;
	}

	@RequestMapping(path = "/register")
	public ModelAndView register(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		if(session.getAttribute("register") == null) {
			session.setAttribute("register", 1);
		}
		return mv;
	}
	
	@RequestMapping(path="/deleteUser")
	public ModelAndView deleteUser(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
		credentialsService.delete(userService.getById(id).getCredentials().getId());
//		userService.delete(id);
		response.sendRedirect("/seeUsers");
		return null;
	}

}
