package club.wayto.todo.controller;

import club.wayto.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import club.wayto.todo.service.IndexService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping("")
	public String index(){
		return "login";
	}
	@RequestMapping("signing-up")
	public String signingUp(){
		return "sign";
	}
	@RequestMapping("login")
	public String login(HttpServletRequest request, ModelMap map){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = indexService.signIn(email, password);
        if(user == null){
            map.addAttribute("msgDanger", "邮箱和密码不匹配，请重新输入！");
            return "login";
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getId());
            map.addAttribute("user", user);
            return "home";
        }
	}

	@RequestMapping("sign-up")
	public String signUp(HttpServletRequest request, ModelMap map){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = indexService.signUp(email, password);
        if(user == null){
            map.addAttribute("msgDanger", "邮箱已被占用，请使用其他邮箱注册！");
            return "sign";
        }else{
            map.addAttribute("user", user);
            map.addAttribute("msg", "注册成功，请登录！");
            return "login";
        }

	}
}
