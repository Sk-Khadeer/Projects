package com.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.miniproject.entity.UserRegister;
import com.miniproject.service.EmailService;
import com.miniproject.service.OtpService;
import com.miniproject.service.UserRegisterService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

	@Autowired
	private UserRegisterService registerService;

	@Autowired
	private OtpService OtpService;

	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String userRegistration(@ModelAttribute UserRegister user, Model model) {
		model.addAttribute("user", user);
		return "register";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword(@ModelAttribute UserRegister user, Model model) {
		return "forgotPassword";
	}

	@PostMapping("/changePassword")
	public String changePassword(@ModelAttribute UserRegister user, Model model,HttpServletResponse response) throws MessagingException {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();

		String s = registerService.changePassword(user);
		int otp = OtpService.generateOTP(user.getEmail());
		String mailId = emailService.sendEmail(s, String.valueOf(otp));
		String names = registerService.gettingNames(user);
		StringBuilder sb = new StringBuilder(mailId);
		for (int i = 3; i < sb.length() && sb.charAt(i) != '@'; ++i) {
			sb.setCharAt(i, '*');
		}
		mailId = sb.toString();
		model.addAttribute("email", mailId);
		model.addAttribute("name", names);

		Cookie c = new Cookie("email", user.getEmail());
		c.setMaxAge(60 * 60 * 5);
		response.addCookie(c);
		Cookie otpcookie = new Cookie("otp", String.valueOf(otp));
		otpcookie.setMaxAge(60 * 60 * 5);
		response.addCookie(otpcookie);

		return "generateOneTimePassword";
	}
		
	@PostMapping("/enterotp")
	public String otp(@ModelAttribute UserRegister user, Model model) {
		return "enterotp";
	}

	@GetMapping("/otpNotValid")
	public String otpNotValid(@ModelAttribute UserRegister user, Model model) {
		return "enterotp";
	}

	@PostMapping("/validOtp")
	public String validateOtp(@ModelAttribute UserRegister user, Model model, @CookieValue("email") String email,
			@CookieValue("otp") String otp) {

		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
		model.addAttribute("validateotp", user.getOtp());
		System.out.println(user.getOtp());
		// Validate the Otp
		if (otp.equals(user.getOtp())) {
			model.addAttribute("email", email);
			model.addAttribute("otp", otp);
			model.addAttribute("message", SUCCESS);
			return "otpValid";
		} else {
			model.addAttribute("message", FAIL);
			return "otpNotValid";
		}
	}

//	@PostMapping("/validOtp")
//	public String validateOtp(Model model, @ModelAttribute UserRegister user) {
////		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		String username = auth.getName();
//		final String SUCCESS = "Entered Otp is valid";
//		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
//		// Validate the Otp
//
//		int serverOtp = OtpService.getOtp(user.getEmail());
//		System.out.println(serverOtp);
//		System.out.println(user.getOtp());
//		if (user.getOtp().equals(String.valueOf(serverOtp))) {
//			OtpService.clearOTP(user.getEmail());
//			model.addAttribute("message", SUCCESS);
//			return "otpValid";
//		} else {
//			model.addAttribute("message", FAIL);
//			return "otpNotValid";
//		}
//	}

	@PostMapping("/newPassword")
	public String newpassword(@ModelAttribute UserRegister user, Model model) {
		final String SUCCESS = "BOTH ARE MATCHING";
		final String FAIL = "BOTH ARE NOT MATCHING . Please Retry!";
		String[] s=user.getPassword().split(",");
			String n=s[0];
			String c=s[1];
			if(n==c) {
				model.addAttribute("message", SUCCESS);
				registerService.updatePassword(user);
				return "newPassword";
			}else {
				model.addAttribute("message", FAIL);
				return "invalidPassword";
			}			
	}

	@PostMapping("/login")
	public String userLogin(@ModelAttribute UserRegister user, Model model) {
		String s = registerService.valid(user);
		model.addAttribute("uname", user.getEmail());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("result", s);
		return "login";
	}

	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") UserRegister user) {
		registerService.saveUser(user);
		return "register_success";
	}

}