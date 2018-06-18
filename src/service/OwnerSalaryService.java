package service;

import domain.*;

public interface OwnerSalaryService extends StaffSalaryService{
	public void createOwnerSalary(OwnerSalaryBean ownerSalaryBean);
	public void addList(OwnerSalaryBean ownerSalary);
	public String share(String sal,String bonus);
}
