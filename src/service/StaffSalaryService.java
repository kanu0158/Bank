package service;

import domain.*;

public interface StaffSalaryService extends SalaryService {
	public StaffSalary createStaffSalary(String name, String dept, String sal);

	public void addList(StaffSalary staffSalary);

	public int createBonus(int sal);
}
