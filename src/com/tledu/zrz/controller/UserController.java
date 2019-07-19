package com.tledu.zrz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tledu.zrz.model.User;
import com.tledu.zrz.model.UserException;
import com.tledu.zrz.service.IUserService;

@Controller
public class UserController {
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	// -----------
//	@RequestMapping("/")
//	public String index() {
//		return "login";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session) throws UserException {
		User loginUser = userService.login(user);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return "redirect:/user/list";
		}
		return "login";
	}

	@RequestMapping(value = "/user/list")
	public String list(Model model, HttpSession session) {
		// 获取session中登录的user
		User loginUser = (User) session.getAttribute("loginUser");
		if (loginUser == null) {
			// 如果没有 就说明没有登录,就返回到登录页面
			return "redirect:/";
		}
		model.addAttribute("users", userService.list());
		return "user/list";
	}
}
