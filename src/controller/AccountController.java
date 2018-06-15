package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

public class AccountController {
	enum AccountButt {
		EXIT, ACCOUNT, MINUSACCOUNT, LIST;
	}

	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		Account ac = null;
		while (true) {
			switch ((AccountButt) JOptionPane.showInputDialog(
					null, "MAIN PAGE", "SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] {
							AccountButt.EXIT, AccountButt.ACCOUNT, AccountButt.MINUSACCOUNT, AccountButt.LIST },
					null)) {
			case EXIT:return;
			case ACCOUNT:
				ac = service.createAccount(JOptionPane.showInputDialog("이름"), JOptionPane.showInputDialog("id"), JOptionPane.showInputDialog("pass"));
				service.addList(ac);
				
				break;
			case MINUSACCOUNT:break;
			case LIST:
				service.showResult();
				break;
			default:break;
			}
		}
	}
}
