package spring08_mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//어떤 기능에 따라 컨트롤러가 하나씩 만들어지고 dispatcher가 요청을 받아서 동작시킨다.

@Controller
public class HelloController {

	//얘가 동작하는 시점이 언제냐~ 를 적어줘야한다.
	@RequestMapping("/hello") //<-- 요청을 매핑한다. 최상위의(/) , hello 에 매핑한다.
	public String hello(
			Model model, // Model이라는  spring이 기본으로 제공하는 class가 있다.
			@RequestParam(value="name",required=false)
			String name) { 
		System.out.println("/hello요청 왔는지 안왔는지 확인");
		model.addAttribute("greeting","안녕하세요" + name);
		return /*/WEB-INF/view/*/"hello";
	}
}
