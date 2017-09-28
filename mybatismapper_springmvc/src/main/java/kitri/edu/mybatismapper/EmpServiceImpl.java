package kitri.edu.mybatismapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpDAO empDAO;
	
	//트랜잭션테스트
	@Override
	public List<EmpVO> getTwoEmpAddList() {
		//empDAO.insertTwoEmp();
		return empDAO.getEmpList();
	}
	
	public List<EmpVO> getAllEmp
	(Map<String, Integer> map) {
		return empDAO.getAllEmp(map);
	}
	public EmpVO getOneEmp(int id) {
		return empDAO.getOneEmp(id);
	}
	public int insertEmp(EmpVO vo) {
		return empDAO.insertEmp(vo);
	}
	public int updateEmp(EmpVO vo) {
		return empDAO.updateEmp(vo);
	}
	public int deleteEmp(int id) {
		return empDAO.deleteEmp(id);
	}
	
	public List<EmpVO> getPagingEmp(int page){
		return empDAO.getPagingEmp(page);
	}
	
	public List<EmpVO> getSearchEmp(EmpVO vo){
		return empDAO.getSearchEmp(vo);
	}
	
}
