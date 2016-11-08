package com.spark.web.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@PropertySource(value="classpath:config.properties")
public class HelloController {

	@Resource
	private Environment environment;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		String st = environment.getProperty("application.name");

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", st);

		return model;

	}

}