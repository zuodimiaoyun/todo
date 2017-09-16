package club.wayto.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import club.wayto.todo.service.IndexService;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping("")
	public String index(){
		return "index";
	}
}
