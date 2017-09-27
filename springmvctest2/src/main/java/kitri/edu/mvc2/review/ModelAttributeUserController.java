package kitri.edu.mvc2.review;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kitri.edu.mvc2.UserVO;

@Controller
public class ModelAttributeUserController {
	@ModelAttribute("userlist") //${userlist}
	//메소드 리턴결과 : 모든 메소드 뷰 공유 모델 
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
	
	@ModelAttribute("searchCondition")
	public ArrayList<String> getModel2(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("id검색");
		list.add("이메일검색");
		list.add("이름검색");

		return list;
	}
	

	@RequestMapping("list.user")
	public String getUserList(@ModelAttribute("userlist") ArrayList<UserVO> list, String searchword, String condition){
		System.out.println("=====getUserList=====");
		System.out.println(list.size());
		return "review/userList";
	}
	//회원리스트 뷰 
	
	@RequestMapping("getId.user")
	public String getUserId(String id){
		System.out.println("=====getUserId=====");
		return "review/getUserId";
	}
	//리스트에서 선택된 id 정보 뷰
	
	@RequestMapping("search.user")
	public String getSearchCondition(){
		return "review/searchCondition"; 
	}
	
	
	
}
