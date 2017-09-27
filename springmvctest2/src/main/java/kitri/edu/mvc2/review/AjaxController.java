package kitri.edu.mvc2.review;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kitri.edu.mvc2.UserVO;

@Controller
public class AjaxController {
	@RequestMapping("ajaxform")
	public String doAjaxForm(){
		return "review/ajax";
	}
	
	@ResponseBody
	@RequestMapping("ajax")
	public UserVO doAjax(@ModelAttribute("ajaxlist") ArrayList<UserVO> list, String name){
		for(UserVO vo : list){
			if (vo.getName().equals(name)) {
				return vo;
			}
		}
		return new UserVO("1", "1", "1", "1");
	}
	
	@ModelAttribute("ajaxlist") 
	public ArrayList<UserVO> getModel(){
		System.out.println("=====getModel=====");
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("java","1111","javaname","java@naver.com"));
		list.add(new UserVO("oracle","2222","oraclename","oracle@naver.com"));
		list.add(new UserVO("spring","3333","springname","spring@naver.com"));
		list.add(new UserVO("mybatis","4444","mybatisname","mybatis@naver.com"));
		list.add(new UserVO("jsp","5555","jspname","jsp@naver.com"));
		return list;
	}
}
 