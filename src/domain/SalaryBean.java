package domain;

public class SalaryBean {
	public static final String DEPT = "인턴쉽";
	protected String dept, name,sal;

	public void setName(String name) {
		this.name = name;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public String getSal() {
		return sal;
	}

	public String toString() {
		return String.format("%s | %s | \n", getName().substring(0, 1) + getDept().substring(0, 2), getSal());
	}
}
