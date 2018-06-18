package controller;

import javax.swing.JOptionPane;

import service.*;
import serviceImpl.*;

public class SalaryController {
	enum SalaryButt {
		EXIT, SALARY, STAFF_SALARY, OWNER_SALARY, LIST;
	}

	public static void main(String[] args) {
		OwnerSalaryService service = new OwnerSalaryServiceImpl();
		while (true) {
			switch ((SalaryButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new SalaryButt[] { SalaryButt.EXIT, SalaryButt.SALARY,
							SalaryButt.STAFF_SALARY, SalaryButt.OWNER_SALARY, SalaryButt.LIST },
					null)) {
			case EXIT:
				return;
			case SALARY:
				service.addList(service.createSalary(JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("직급"), JOptionPane.showInputDialog("기본급")));
				break;
			case STAFF_SALARY:
				service.addList(service.createStaffSalary(JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("직급"), JOptionPane.showInputDialog("기본급")));
				break;
			case OWNER_SALARY:
				service.addList(service.createOwnerSalary(JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("직급"), JOptionPane.showInputDialog("기본급")));
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
