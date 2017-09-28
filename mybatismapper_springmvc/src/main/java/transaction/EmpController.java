package transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@Autowired
	EmpServiceImpl service;
	
	@RequestMapping("emplist.transaction")
	public ModelAndView getTwoEmpAddList(){
		//service-dao
		// 2개 employees 데이터 저장-조회
		// 1개만 저장, 1개 오류 
		List<EmpVO> list = service.getEmpList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("transaction/emplist");
		return mav;
	}
}
