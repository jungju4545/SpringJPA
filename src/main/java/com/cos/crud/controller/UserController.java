package com.cos.crud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;
import com.cos.crud.utils.Script;

@Controller
public class UserController {
	@Autowired
	private UserRepository mRepo;
	
	@PostMapping("/user/login")
	public @ResponseBody String userLogin  (User user, HttpSession session) { //sesstion, response는 만들면 알아서 해줌
		User u = mRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(u!=null) {
			session.setAttribute("user", u);
			return Script.href("/");
		}else {
			return Script.back("login fail");
		}
	}
	@GetMapping("/user/loginForm")
	public String userLoginForm() {
		return "/user/loginForm";
	}
	@PostMapping("/user/join") // post이니 데이터가 넘어온다. user정보가 넘어오면 어떻게 받는가? 
	public String userJoin(User user) {
		mRepo.save(user); // 자동적으로 insert, update제공
		return "redirect:/";
	}
	@GetMapping("/user/joinForm")
	public String userJoinForm() {
		return "/user/joinForm";
	}
	
	@GetMapping("/user/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
