package serviceImpl;

import domain.SalaryBean;
import service.*;

public class SalaryServiceImpl implements SalaryService {
	protected SalaryBean[] list;
	protected int count;

	public SalaryServiceImpl() {
		list = new SalaryBean[100];
		count = 0;
	}

	@Override
	public void createSalary(SalaryBean salaryBean) {
		addList(salaryBean);
	}

	@Override
	public void addList(SalaryBean salary) {
		list[count++] = salary;
	}

	@Override
	public SalaryBean[] list() {
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
