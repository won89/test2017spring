package kitri.edu.mybatismapper;

import java.util.List;
import java.util.Map;

//main, controller 요청 1개 기능 - 1개 메소드

public interface EmpService {
	//트랜잭션테스트
	List<EmpVO> getTwoEmpAddList();
	
	//전체employee조회
	List<EmpVO> getAllEmp(Map<String, Integer> map);
	
	//사번employee조회
	EmpVO getOneEmp(int id);
	
	//저장
	int insertEmp(EmpVO vo);
	
	//수정, 
	int updateEmp(EmpVO vo);
	
	//삭제 
	int deleteEmp(int id);
}
