package domain;

public class StaffSalary extends Salary {
	public static final String DEPT = "정직원";
	protected int bonus;

	@Override
	public void setDept(String dept) {
		super.dept = dept;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return String.format("%s | %d | %d | %d |\n", getName().substring(0, 1) + getDept().substring(0, 2), getSal(),
				getBonus(), getSal() + getBonus());
	}

}
