package domain;

public class Salary {
	public static final String DEPT = "인턴쉽";
	protected String dept, name;
	protected int sal;

	public void setName(String name) {
		this.name = name;
	}

	public void setSal(int sal) {
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

	public int getSal() {
		return sal;
	}

	public String toString() {
		return String.format("%s | %d | \n", getName().substring(0, 1) + getDept().substring(0, 2), getSal());
	}
}
