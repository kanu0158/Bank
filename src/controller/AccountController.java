package controller;

import javax.swing.JOptionPane;

import service.*;
import serviceImpl.*;

public class AccountController {
enum AccountButt {
		EXIT, ACCOUNT, MINUSACCOUNT, LIST;
}

	public static void main(String[] args) {
		MinusAccountService service = new MinusAccountServiceImpl();
		while(true) {
			switch((AccountButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] { AccountButt.EXIT, AccountButt.ACCOUNT,
							AccountButt.MINUSACCOUNT, AccountButt.LIST },
					null)) {
			case EXIT:return;
			case ACCOUNT:
				
				service.addList(service.createAccount(JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("아이디"),
						JOptionPane.showInputDialog("패스워드")));
				break;
			case MINUSACCOUNT:
				service.addList(service.createMinusAccount(JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("아이디"),
						JOptionPane.showInputDialog("패스워드")));
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.showResult());
				break;
			default:break;
			}
		}
	}

}
