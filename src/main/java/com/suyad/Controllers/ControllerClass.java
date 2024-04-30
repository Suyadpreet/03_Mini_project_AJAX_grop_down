package com.suyad.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.suyad.credentials.CredentialCheck;

@Controller
public class ControllerClass 
{
	@GetMapping("/loginpage")
	public String loginpage(Model model)
	{
		CredentialCheck check = new CredentialCheck();
		check.setName("Suyadpreet@gmail.com");
		model.addAttribute("credits", check);
		return "loginpage";
	}
	@GetMapping("/loginsuccess")
	public String loginSuccesspage(@ModelAttribute("credits")CredentialCheck check,Model model)
	{
		System.out.println("User name = "+check.getName());
		System.out.println("Password = "+check.getPassword());
		model.addAttribute("msg", "Login Success fully Welcome to Web Portel");
		return "loginsuccess";
	}
	
	@GetMapping("/loginfailure")
	public String loginFailurepage(Model model)
	{
		model.addAttribute("msg", "Login Failed");
		return "loginfailure";
	}
	
	@GetMapping("/forgetpassword")
	public String forgetPasswordpage(Model model)
	{
		model.addAttribute("msg", "Please Reset your password here");
		return "forgetpassword";
	}
	
	@GetMapping("/signup")
	public String signupPage(Model model)
	{
		model.addAttribute("msg", "Please reginster Yourself here");
		return "signupPage";
	}
}
