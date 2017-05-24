package edu.hanoi.jazz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Hello Java Clazz");
		return mav;
	}
	
	@RequestMapping("/nguoi-dung")
	public ModelAndView forUser(){
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "This is protected page!");
		return mav;
	}
	
	@RequestMapping(value="/dang-nhap")
	public ModelAndView login(@RequestParam(value="error", required=false)String error){
		ModelAndView mav = new ModelAndView("login");
		if(error != null) mav.addObject("error", error);
		return mav;
	}
}
