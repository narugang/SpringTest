package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping(value="/register/step1")
//			method= RequestMethod.POST/*,RequestMethod.GET}*/)
	public String handleStep1() {
		return "register/step1";
	}
	
	public String handleStep2(HttpServletRequest request) {
		String agreeParam = request.getParameter("agree");
		if(agreeParam == null || !agreeParam.equals("true")) {
			return "register/step1";
		}
		return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(
			@RequestParam(value="agree", defaultValue="false") Boolean agree,
			Model model) { // 요청 파라미터 개수가 몇 개 안 되는 경우 사용하면 유용
		if(!agree) {
			return "register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq,
			Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);	// 이 처럼 Errors를 전달받도록 정의하면 스프링 MVC는 자동으로 커맨드 객체와 연결된 
		if(errors.hasErrors()) {									// Errors객체를 생성하여 전달한다. Errors객체에 정의되어 있는 getFieldValue()를 사용하여 커맨드 객체의 특정 값을 얻어올 수 있다.
			return "register/step2";								// 그래서 커맨드 객체를 직접 전달받지 않아도 Errors객체를 통해 지정한 값을 구할 수 있다.
		}		
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}
		catch(AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
}
