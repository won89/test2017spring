package kitri.edu.mvc2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	@RequestMapping("doA")
	public ModelAndView doA(){
		//CharacterEncodingFilter
		ModelAndView m = new ModelAndView();
		//Model : view 전달 내용(문자열 객체 콜렉션)
		m.addObject("model", "doA메소드 실행했습니다.");
		//view 결과 응답 파일
		m.setViewName("sample/doA");
		return m;
	}
	
	@RequestMapping("doB")
	public ModelAndView doB(){
		//CharacterEncodingFilter
		ModelAndView m = new ModelAndView();
		//Model : view 전달 내용(문자열 객체 콜렉션)
		m.addObject("model", "doB메소드 실행했습니다.");
		//view 결과 응답 파일
		m.setViewName("sample/doB");
		return m;
	}
	/*
	 * get방식 사용방법
	 * 주소표시줄에 직접 입력 
	 * <a href="....내부에 직접 값 입력
	 * <form ... method=get 액션 태그에 사용하는 법 
	 * */
	@RequestMapping(value="login", method=RequestMethod.GET)
	//로그인폼 메소드 
	public ModelAndView loginform(@ModelAttribute("loginVO") LoginVO vo){
		ModelAndView m = new ModelAndView();
		m.setViewName("login/loginform");  
		//jsp: 자동전달 : loginVO 이름 
		return m;
	}
	
//	@RequestMapping(value="login" ,method=RequestMethod.POST)
//	//로그인 가능 판단 메소드 
//	public ModelAndView loginresult(LoginVO inputVO){
////		System.out.println(inputVO.getId());
////		System.out.println(inputVO.getPw());
//		ArrayList<LoginVO> list = new ArrayList<LoginVO>();
//		list.add(new LoginVO("id1", "pw1"));
//		list.add(new LoginVO("id2", "pw2"));
//		list.add(new LoginVO("id3", "pw3"));
//		//사용자 입력 id/ pw 전달
////		String id = request.getParameter("id");
////		String pw = request.getParameter("pw");
//		ModelAndView m = new ModelAndView();
//		m.addObject("inputVO", inputVO);
//		String viewName = "";
//		//사용자 아이디 내부 포함 여부 확인 
//		for (LoginVO vo : list) {
//			if (vo.getId().equals(inputVO.getId()) && vo.getPw().equals(inputVO.getPw())) {
//				viewName="login/user";
//				break;
//			}else{
//				viewName="login/guest";
//			}	
//		}
//		m.setViewName(viewName);
//		return m;
//	}
	
	
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	//로그인 가능 판단 메소드 
	public ModelAndView loginresult(@RequestParam(value="page", required=false, defaultValue="1") int pagenum, @RequestParam("id") String id1,@RequestParam("pw") String pw1){
		System.out.println(pagenum);
		ArrayList<LoginVO> list = new ArrayList<LoginVO>();
		list.add(new LoginVO("id1", "pw1"));
		list.add(new LoginVO("id2", "pw2"));
		list.add(new LoginVO("id3", "pw3"));
		//사용자 입력 id/ pw 전달
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		ModelAndView m = new ModelAndView();
	//	m.addObject("inputVO", inputVO);
		String viewName = "";
		//사용자 아이디 내부 포함 여부 확인 
		for (LoginVO vo : list) {
			if (vo.getId().equals(id1) && vo.getPw().equals(pw1)) {
				m.addObject(vo);
				viewName="login/user";
				break;
			}else{
				viewName="login/guest";
			}	
		}
		m.setViewName(viewName);
		return m;
	}
	
	@RequestMapping(value="logout")
	String logout(String id){
		return "redirect:/login?id="+id+"";
	}
	
	
	//로그인 가능 판단 메소드 
//	public ModelAndView logout(String id){
//		ModelAndView m = new ModelAndView();
//		m.addObject("id", id);
//		m.setViewName("login/logout");
//		return m;
//	}
	
	@RequestMapping("doC")
	public String doC(){
		return "home";
	}
	@RequestMapping("doD")
	public void doD(){}
	
	@RequestMapping("doE")
	public LoginVO doE(){
		return new LoginVO("java","java");
	}
	
	@RequestMapping("doF")
	public String doF(){
		return "redirect:/doD";
		//만약 redirect : 시작 : 다른 uri 매핑 메소드 view 공유 
	}
}
