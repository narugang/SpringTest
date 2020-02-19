package survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {

//	@RequestMapping(method=RequestMethod.GET)
//	public String form(Model model) {
//		List<Question> questions = createQuestions();
//		model.addAttribute("questions", questions);
//		return "survey/surveyForm";
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(Model model) {
		List<Question> questions = createQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("question",questions);
		//모델 객체 지정
		mav.setViewName("survey/surveyForm");
		//뷰 이름 지정
		return mav;
	}
	
	
	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은?",
				Arrays.asList("서버","프론트","풀스택"));
		Question q2 = new Question("주로 사용하는 개발 도구는?",
				Arrays.asList("이클립스","인텔리J","서브라임"));
		Question q3 = new Question("하고 싶은 말?");
				
		return Arrays.asList(q1,q2,q3);
	}

	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("ansData")AnsweredData data) {
		return "survey/submitted";
	}
}
