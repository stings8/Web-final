package com.ufc.br.controller;

import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/")
	public ModelAndView home() {

		ModelAndView view = new ModelAndView("index");
		view.addObject("produtos", service.findAll());
		return view;
	}

}
