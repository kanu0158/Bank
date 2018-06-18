package serviceImpl;

import domain.OwnerSalary;
import service.OwnerSalaryService;

public class OwnerSalaryServiceImpl extends StaffSalaryServiceImpl implements OwnerSalaryService {

	@Override
	public OwnerSalary createOwnerSalary(String name, String dept, String sal) {
		OwnerSalary os = new OwnerSalary();
		os.setName(name);
		os.setDept(dept);
		os.setSal(Integer.parseInt(sal));
		os.setBonus(createBonus(Integer.parseInt(sal)));
		os.setShare(share(os.getSal(), os.getBonus()));
		return os;
	}

	@Override
	public void addList(OwnerSalary ownerSalary) {
		list[super.count++] = ownerSalary;
	}

	@Override
	public int share(int sal, int bonus) {
		return (sal + bonus) * 10;
	}

}
