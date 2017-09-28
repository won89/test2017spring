package transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDAO empDAO;
	
	public void setEmpDAO(EmpDAO empDAO){
		this.empDAO = empDAO;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, 
			propagation=Propagation.REQUIRED,
			rollbackFor=java.sql.SQLException.class)
	
	public List<EmpVO> getEmpList() {
		return empDAO.getEmpList();
	}
}
