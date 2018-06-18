package serviceImpl;

import domain.Salary;
import service.*;

public class SalaryServiceImpl implements SalaryService {
	protected Salary[] list;
	protected int count;

	public SalaryServiceImpl() {
		list = new Salary[100];
		count = 0;
	}

	@Override
	public Salary createSalary(String name, String dept, String sal) {
		Salary s = new Salary();
		s.setName(name);
		s.setDept(dept);
		s.setSal(Integer.parseInt(sal));
		return s;
	}

	@Override
	public void addList(Salary salary) {
		list[count++] = salary;
	}

	@Override
	public Salary[] list() {
		return list;
	}

	@Override
	public String showResult() {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += list()[i].toString();
		}
		return result;
	}
}
