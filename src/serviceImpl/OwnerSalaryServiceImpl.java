package serviceImpl;

import domain.OwnerSalaryBean;
import service.OwnerSalaryService;

public class OwnerSalaryServiceImpl extends StaffSalaryServiceImpl implements OwnerSalaryService {

	@Override
	public void createOwnerSalary(OwnerSalaryBean ownerSalaryBean) {
		ownerSalaryBean.setBonus(createBonus(ownerSalaryBean.getSal()));
		ownerSalaryBean.setShare(share(ownerSalaryBean.getSal(), ownerSalaryBean.getBonus()));
		addList(ownerSalaryBean);
	}

	@Override
	public void addList(OwnerSalaryBean ownerSalary) {
		list[super.count++] = ownerSalary;
	}

	@Override
	public String share(String sal, String bonus) {
		return String.valueOf((Integer.parseInt(sal) + Integer.parseInt(bonus)) * 10);
	}

}
