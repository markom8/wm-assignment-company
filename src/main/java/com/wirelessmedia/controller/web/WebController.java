package com.wirelessmedia.controller.web;

import com.wirelessmedia.AssignmentApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController
{

	@Controller
	public class HomeController {
		@RequestMapping("/")
		public String home() {
			return "home";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
}
