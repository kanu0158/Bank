package domain;

public class StaffSalaryBean extends SalaryBean {
	public static final String DEPT = "정직원";
	protected String bonus;

	@Override
	public void setDept(String dept) {
		super.dept = dept;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return String.format("%s | %s | %s | %d |\n", getName().substring(0, 1) + getDept().substring(0, 2), getSal(),
				getBonus(), Integer.parseInt(getSal()) + Integer.parseInt(getBonus()));
	}

}
