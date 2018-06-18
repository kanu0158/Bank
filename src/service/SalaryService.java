package service;

import domain.*;

public interface SalaryService {
	public void createSalary(SalaryBean salaryBean);
	public void addList(SalaryBean salary);
	public SalaryBean[] list();
	public String showResult();
}
