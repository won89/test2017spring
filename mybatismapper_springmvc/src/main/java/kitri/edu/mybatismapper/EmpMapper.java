package kitri.edu.mybatismapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {
/*<select id="pagingemp" 
parameterType="int[]" resultType="EmpVO" >
	select r, employee_id, first_name, last_name, 
	phone_number phone
	from (select a.*, rownum r
		from 
		(select * from employees order by hire_date) a
	)
	where r between 
	<foreach collection="array" item="r" 
	separator="and">
	#{r}
	</foreach>
</select>
 * */	
//allemp.mapper?id1=100&id2=200
	@Select("select * from employees "
			+ "where employee_id=#{first}"
			+ "or employee_id=#{second}")
	public List<EmpVO> getAllEmpMapper
	(Map<String, Integer> map);
	
	@Select("select * from employees "
			+" where employee_id=#{id}")
	public EmpVO getOneEmpMapper (int id);
}

// 컨트롤러  : oneemp.mapper url 입력

//컨트롤러 :EmpVO :  employee_id : 10000
//                  first_name, last_name, phone : null
/* select * from employees
 * where employee_id >= 10000
 * or first_name like ?
 * or last_name like null
 * or phone_number like null
 * */
/*
 * 1. annotation 방식 : xml 태그x:설정 간편
 *   수정-컴파일-실행
 *   sql 단순
 * 2. xml 태그 방식 : 설정 복잡. xml 파일만 조회 전체 객체 관계
 * 수정-재컴파일 x
 * sql 다이나믹
 * 
 * mybatis : 1 + 2 
 */









