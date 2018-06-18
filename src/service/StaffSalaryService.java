package service;

import domain.*;

public interface StaffSalaryService extends SalaryService {
	public void createStaffSalary(StaffSalaryBean staffSalaryBean);

	public void addList(StaffSalaryBean staffSalary);

	public String createBonus(String sal);
}
