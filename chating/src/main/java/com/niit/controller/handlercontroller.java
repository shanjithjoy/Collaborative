package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.niit.model.Message;
import com.niit.services.MessageService;

@Controller
public class handlercontroller {

	@Autowired
	MessageService messageService;
	
	@RequestMapping("/")
	public String index(){
	return "index";
	}
	
	@RequestMapping("chat")
	public String chat(@ModelAttribute("message")Message nessage,Model m,HttpServletRequest r){
	String name=r.getParameter("username");
	List<Message> msgLt=messageService.getList();
	/*Gson g=new Gson();
	String msgList=g.toJson(msgLt);*/
	m.addAttribute("msgs", msgLt);
	m.addAttribute("username", name);
	return "chat";
	}
	
	@RequestMapping(value="/sendMsg",method=RequestMethod.POST)
	public String send(@ModelAttribute("message")Message message,Model m,HttpServletRequest r){
	String name=r.getParameter("username");
	message.setTime(new Date());
	message.setUsername(name);
	messageService.insertRow(message);
	List<Message> msgLt=messageService.getList();
	m.addAttribute("msgs", msgLt);
	m.addAttribute("username", name);
	return "chat";
	}
		
}

