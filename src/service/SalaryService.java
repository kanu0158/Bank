package service;

import domain.*;

public interface SalaryService {
	public Salary createSalary(String name,String dept,String sal);
	public void addList(Salary salary);
	public Salary[] list();
	public String showResult();
}
