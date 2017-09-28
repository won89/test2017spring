package kitri.edu.mybatismapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmpDAO {
	@Autowired
	SqlSession session;

	@Autowired
	EmpMapper mapper;
	
	//트랜잭션처리용 
	public void insertTwoEmp(){
		try{
		System.out.println
		(session.getConnection().getAutoCommit());
		}catch(Exception e){ 
			e.printStackTrace();
		}
		
		try{
		EmpVO vo1 = new EmpVO();
		vo1.setEmployee_id(3012);
		vo1.setFirst_name("트랜잭션");
		vo1.setLast_name("처리");
		vo1.setEmail("tran3012@a.com");
		vo1.setPhone("0112223333");
		vo1.setJob_id("IT_PROG");
		session.insert("transaction.insertEmp", vo1);//mapper.xml파일 설정 sql
		System.out.println("====insert1 ok====");
		EmpVO vo2 = new EmpVO();
		vo2.setEmployee_id(3012);
		vo2.setFirst_name("트랜잭션");
		vo2.setLast_name("처리");
		vo2.setEmail("tran30121@a.com");
		vo2.setPhone("0112223333");
		vo2.setJob_id("IT_PROG");
		session.insert("transaction.insertEmp", vo2);//mapper.xml파일 설정 sql
		System.out.println("====insert2 ok====");	
		//session.getConnection().commit();
		}catch(Exception e){
			System.out.println("====예외발생====");
			//try{
				//session.getConnection().rollback();
			//}catch(Exception e2){}
			throw e;
		}
	}
	
	public List<EmpVO> getEmpList(){
		try{
		System.out.println
		(session.getConnection().getAutoCommit());
		}catch(Exception e){ 
			e.printStackTrace();
		}
		
		try{
		EmpVO vo1 = new EmpVO();
		vo1.setEmployee_id(2013);
		vo1.setFirst_name("트랜잭션");
		vo1.setLast_name("처리");
		vo1.setEmail("tran2013@a.com");
		vo1.setPhone("0112223333");
		vo1.setJob_id("IT_PROG");
		session.insert("transaction.insertEmp", vo1);//mapper.xml파일 설정 sql
		System.out.println("====insert1 ok====");
		EmpVO vo2 = new EmpVO();
		vo2.setEmployee_id(2013);
		vo2.setFirst_name("트랜잭션");
		vo2.setLast_name("처리");
		vo2.setEmail("tran20131@a.com");
		vo2.setPhone("0112223333");
		vo2.setJob_id("IT_PROG");
		session.insert("transaction.insertEmp", vo2);//mapper.xml파일 설정 sql
		System.out.println("====insert2 ok====");	
		//session.getConnection().commit();
		}catch(Exception e){
			System.out.println("====예외발생====");
			//try{
				//session.getConnection().rollback();
			//}catch(Exception e2){}
			throw e;
		}
		return session.selectList("transaction.allEmp");
	}
	
	//test1: 테이블 전체 레코드 조회
	List<EmpVO> getAllEmp(Map<String, Integer> map){
		List<EmpVO> list = mapper.getAllEmpMapper(map); 
				//session.selectList("emp.all");
		return list;
	}
	//test2:파라미터 입력 해당 레코드 1개 조회
	EmpVO getOneEmp(int id){
		EmpVO vo2 = session.selectOne("emp.one", 100);
	return vo2;
	}
	
//test4-2 : insert:parateterrType 필요, resultType 필요없는 sql
	public int insertEmp(EmpVO vo){
	 return 
	 session.insert("emp.createWithSelectKey", vo);
	}
	
	
	//test5 : update:resultType 필요없는 sql
	// emp.update 매핑 sql 실행
	public int updateEmp(EmpVO vo){
		return session.update("emp.update", vo);
	}
	
	//test6 : delete:resultType 필요없는 sql
	public int deleteEmp(int id){
		return session.delete("emp.delete", id);
	}
	
	public List<EmpVO> getPagingEmp(int page){
		int start = (page-1)*10 + 1;
		int end = page*10;
		int rownum[] = new int[2];
		rownum[0] = start;
		rownum[1] = end;
		return session.selectList("emp.pagingemp", rownum);
	}
	
	public List<EmpVO> getSearchEmp(EmpVO vo){
		System.out.println(vo);
		return session.selectList("emp.searchemp", vo);
	}
}//EmpDAO END






