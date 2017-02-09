package com.anand.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value= "/home", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String home() {
		return "home..";
	}
}