package serviceImpl;

import domain.*;
import service.*;

public class StaffSalaryServiceImpl extends SalaryServiceImpl implements StaffSalaryService {
	@Override
	public StaffSalary createStaffSalary(String name, String dept, String sal) {
		StaffSalary st = new StaffSalary();
		st.setName(name);
		st.setDept(dept);
		st.setSal(Integer.parseInt(sal));
		st.setBonus(createBonus(Integer.parseInt(sal)));
		return st;
	}

	@Override
	public void addList(StaffSalary staffSalary) {
		list[super.count++] = staffSalary;
	}

	@Override
	public int createBonus(int sal) {
		return sal * 10 / 100;
	}

}
