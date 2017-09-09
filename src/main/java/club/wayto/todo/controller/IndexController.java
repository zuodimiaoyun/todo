package club.wayto.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import club.wayto.todo.service.IndexService;


@RestController
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping("")
	@ResponseBody
	public String index(){
		indexService.index();
		return "Hello World";
	}
}
