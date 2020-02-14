package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @Controller : 스프링 MVC에서 컨트롤러로 사용한다고 선언
 * 
 * @RequestMapping : 메서드가 처리할 경로 지정(클라이언트에서 요청하는 경로)
 * 
 * Model 파라미터 : 컨트롤러의 처리 결과를 뷰에 전달하는 역할
 * 
 * @RequestParam : HTTP요청 값을 메서드의 파라미터로 전달하는 역할
 * 
 * addAttribute : greeting 속성에 값을 설정
 * 
 * return hello : 컨트롤러의 처리결과를 보여줄 뷰 지정
 * */


/*
 * 웹 브라우저의 hello요청을 HelloController가 처리를 하여 hello.jsp가 실행된 결과가 브라우저에 나타나게 되는 것을 하나의 흐름으로 이해하도록 한다.
 * 중간에 greeting속성의 값이 지정된 model객체를  jsp페이지의 표현식 ${greeting}을 통해 뷰 페이지에 출력이 되었다.
 * 
 * 여기까지가 가장 기본적인 스프링 MVC패턴의 흐름을 확인해 본 것이다. 이 개념을 확실히 이해하여 중심을 잡고 거기에 서비스나 DAO동작, 요청 값 검증,
 * 커스텀 태그, 세션 쿠키, 인터셉터 등이 추가되어 개발이 진행된다고 생각하면 된다.
 * 
 * */

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(
				Model model, @RequestParam(value = "name", required = false)
				String name) {
		
		model.addAttribute("greeting", "안녕하세요, " + name);
		return "hello";
	}
	
}
