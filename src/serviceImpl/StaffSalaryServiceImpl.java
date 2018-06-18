package serviceImpl;

import domain.*;
import service.*;

public class StaffSalaryServiceImpl extends SalaryServiceImpl implements StaffSalaryService {
	@Override
	public void createStaffSalary(StaffSalaryBean staffSalaryBean) {
		staffSalaryBean.setBonus(createBonus(staffSalaryBean.getSal()));
		addList(staffSalaryBean);
	}

	@Override
	public void addList(StaffSalaryBean staffSalary) {
		list[super.count++] = staffSalary;
	}

	@Override
	public String createBonus(String sal) {
		return String.valueOf(Integer.parseInt(sal) * 10 / 100);
	}

}
