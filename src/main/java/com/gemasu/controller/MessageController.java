package com.gemasu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mymessages")
public class MessageController {
	
	@Autowired
	private MyMessage newMessage;
	
	@RequestMapping("/")
	public String getMessage(Model model) {
		
		model.addAttribute("newMessage", newMessage.getMessage());
		
		return "viewMessage";
	}
}