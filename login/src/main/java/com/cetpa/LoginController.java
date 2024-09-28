package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController 
{
	@RequestMapping("login-form")
	public String getLoginView()
	{
		return "login";
	}
	@RequestMapping("authentication")
	public String validateLogin(String uid,String pass,Model model)
	{
		if(uid.equals("admin") && pass.equals("cetpa"))
			return "home";
		model.addAttribute("msg","Authentication failed...");
		return "login";
	}
}
