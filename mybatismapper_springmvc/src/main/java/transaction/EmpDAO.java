package transaction;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EmpDAO  {
	@Autowired
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<EmpVO> getEmpList(){
		//TEST1-MAPPER.XML�� insert �±� ������ �Ŀ� 2���� insert �����ϸ鼭 (1���� �ǵ������� �߸��� �ڵ�
		try{
			//트랜잭션설정없으면 true, 있으면 false
		System.out.println(sqlSession.getConnection().getAutoCommit());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//test1 : 301, 302 2개 모두 insert완료(sqlplus로확인)
		//test2 : 303, 303 :pk 위배로 1번만 insert완료
		//test3 : try-catch : 예외시 롤백 . 304, 304, 2개모두 insert안됨.
		//test4 : test3부분 없애고 xml 설정 따름. 305, 306(이메일은 동일하게 넣자)
		// "insert1 ok" 출력되지만 실제로 insert안됨(롤백되어서)
		
		try{
		EmpVO vo1 = new EmpVO();
		vo1.setEmployee_id(3016);
		vo1.setFirst_name("유진");
		vo1.setLast_name("김");
		vo1.setEmail("kim_emai3016@mail.com");
		vo1.setJob_id("IT_PROG");
		vo1.setDepartment_id(80);
		vo1.setPhone("01022223333");
		sqlSession.insert("transaction.insertEmp", vo1);
		System.out.println("===========insert1 ok=========");
		
		EmpVO vo2 = new EmpVO();
		vo2.setEmployee_id(3016);
		vo2.setFirst_name("유진");
		vo2.setLast_name("박");
		vo2.setEmail("park_email3016@mail.com");
		vo2.setJob_id("IT_PROG");
		vo2.setDepartment_id(90);
		vo2.setPhone("01022223333");
		sqlSession.insert("transaction.insertEmp", vo2);
		System.out.println("===========insert2 ok=========");
		//����Ȯ���� �� 
		
		}catch(Exception e){
			//==없애자
			//try{
			//	sqlSession.getConnection().rollback();
			//}catch(Exception e2){}
			//==없애자
			System.out.println("예외발생");
			throw e;
		}
		
		List<EmpVO> list = sqlSession.selectList("transaction.one", 304);
		System.out.println("----------------------------------------------------------------");
		for (EmpVO vo : list)
			System.out.println(vo.getEmployee_id() + " / " + vo.getLast_name()
					+ " / " + vo.getJob_id() );
		System.out.println("----------------------------------------------------------------");
		return list;

	}
}











