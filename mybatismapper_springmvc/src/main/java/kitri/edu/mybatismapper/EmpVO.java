package kitri.edu.mybatismapper;
//HR EMPLOYEES 결과 저장 - 파라미터값 전송 
//desc employees
public class EmpVO {
	int employee_id;
	String first_name;
	String last_name;
	String email;
	String hire_date;
	String job_id;
	double salary;
	int department_id;
	String phone;//column name phone_number
	
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public EmpVO(){ }
		
	public EmpVO(int employee_id, String first_name, 
	String last_name, String email, 
	String hire_date, String job_id,
	int department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.department_id = department_id;
	}


	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	@Override
	public String toString() {
		return "EmpVO [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", hire_date=" + hire_date + ", job_id=" + job_id + ", salary=" + salary
				+ ", department_id=" + department_id + ", phone=" + phone + "]";
	}
	
}
