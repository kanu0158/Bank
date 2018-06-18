package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

public class EmployeeController {
	enum SalaryButt {
		EXIT, SALARY, STAFF_SALARY, OWNER_SALARY, LIST;
	}

	public static void main(String[] args) {
		OwnerSalaryService service = new OwnerSalaryServiceImpl();
		SalaryBean sb = null;
		StaffSalaryBean ssb = null;
		OwnerSalaryBean osb = null;
		while (true) {
			switch ((SalaryButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new SalaryButt[] { SalaryButt.EXIT, SalaryButt.SALARY,
							SalaryButt.STAFF_SALARY, SalaryButt.OWNER_SALARY, SalaryButt.LIST },
					null)) {
			case EXIT:
				return;
			case SALARY:
				sb = new SalaryBean();
				sb.setName(JOptionPane.showInputDialog("이름"));
				sb.setDept(JOptionPane.showInputDialog("직급"));
				sb.setSal(JOptionPane.showInputDialog("기본급"));
				service.createSalary(sb);
				break;
			case STAFF_SALARY:
				ssb = new StaffSalaryBean();
				ssb.setName(JOptionPane.showInputDialog("이름"));
				ssb.setDept(JOptionPane.showInputDialog("직급"));
				ssb.setSal(JOptionPane.showInputDialog("기본급"));
				service.createStaffSalary(ssb);
				break;
			case OWNER_SALARY:
				osb = new OwnerSalaryBean();
				osb.setName(JOptionPane.showInputDialog("이름"));
				osb.setDept(JOptionPane.showInputDialog("직급"));
				osb.setSal(JOptionPane.showInputDialog("기본급"));
				service.createOwnerSalary(osb);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.showResult());
				break;
			default:
				break;
			}
		}
	}

}
