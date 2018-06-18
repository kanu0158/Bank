package service;

import domain.*;

public interface OwnerSalaryService extends StaffSalaryService{
	public OwnerSalary createOwnerSalary(String name,String dept,String sal);
	public void addList(OwnerSalary ownerSalary);
	public int share(int sal,int bonus);
}
