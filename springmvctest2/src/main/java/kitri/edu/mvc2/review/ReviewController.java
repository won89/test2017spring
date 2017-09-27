package kitri.edu.mvc2.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//http://ip/port/mvc2/review
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ReviewController {
	@RequestMapping("review")
	public String reviewhome(){
		System.out.println("home called");
		return "/review/reviewhome";
	}
	
	@RequestMapping("review/doA")
	public String doA(Model model){
		//ModelAndView: 모델 , 뷰 설정 정보 객체 
		model.addAttribute("message", "doA 수행합니다.");
		System.out.println("doA called");
		return "review/doA";
		
	}
	
	@RequestMapping("review/doB")
	public void doo(){
		//review/doB
		System.out.println("doB called ~~");
	}
	
	@RequestMapping("review/doC")
	public ModelAndView doC(){
		System.out.println("doC called ~~");
		Map<String, String> productMap = new HashMap<String, String>();
		productMap.put("tv", "2000000원");
		productMap.put("컴퓨터", "2000000원");
		productMap.put("마우스", "1000원");
		ModelAndView mav = new ModelAndView();
		//모델에 map 형태의 컬렉션 전달
		mav.addObject("productMap", productMap);
		mav.setViewName("review/doC");
		return mav;
	}
	/*
	 * http:ip:port/mvc2/review/doD요청
	 * ->doE 요청 
	 * */
	
	@RequestMapping("review/doD")
	public String doD(){
		System.out.println("doD called");
		return "redirect:/review/doE";
	}
	
	@RequestMapping("review/doE")
	public void doE(){
		System.out.println("doE called");
	}
	
	@RequestMapping(value="review/doF", method=RequestMethod.GET)
	//http://...?id=xxx
	public ModelAndView doF(@RequestParam(value= "id1", required= false, defaultValue="java") String id){
//		@ModelAttribute("id") = 는 아래 두줄 쓴 것과 같은 효과
		ModelAndView m = new ModelAndView();
		m.addObject("id", id);
		m.setViewName("review/doF");
		System.out.println("입력값 =" + id);
		return m;
	}
}
