package transaction;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest_Transaction {
public static void main(String[] args) {
//1. spring bean 설정 파일 읽어라
	ApplicationContext factory
	= new ClassPathXmlApplicationContext
	("transaction/springbean_transaction.xml");
	
//2. 서비스객체 얻어와라
//spring-service인터페이스/serviceImpl상속/dao/vo/db	
	EmpService service = (EmpService)factory.getBean("empService");
//3.서비스객체 : 모든 멤버 조회 mybatis 연동
	List<EmpVO> list = service.getEmpList();
//4.출력	
	for(int i = 0; i < list.size(); i++){
		EmpVO vo2 = list.get(i);
		System.out.println(vo2.getEmployee_id() + " / " + vo2.getLast_name()
				+ " / " + vo2.getJob_id() );
	}
}
}








