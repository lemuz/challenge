package com.equifax.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dummy.DummyTest;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private DummyTest dummy;
	
	@GetMapping("")
	public String index() {
		return dummy.test1().toString();
		//return "index";
	}
}