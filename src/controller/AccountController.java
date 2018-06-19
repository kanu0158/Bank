package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

public class AccountController {
enum AccountButt {
		EXIT, ACCOUNT, MINUSACCOUNT, LIST, FIND_BY_ID, FIND_BY_NAME, MINUS_LIST, CHANGE_PASS, DELETE_ACCOUNT;
}

	public static void main(String[] args) {
		AccountService service = new MinusAccountServiceImpl();
		AccountBean acb = null; 
		MinusAccountBean mab = null;
		while(true) {
			switch((AccountButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new AccountButt[] { AccountButt.EXIT, AccountButt.ACCOUNT,
							AccountButt.MINUSACCOUNT, AccountButt.LIST, AccountButt.FIND_BY_ID, AccountButt.FIND_BY_NAME, AccountButt.MINUS_LIST, AccountButt.CHANGE_PASS, AccountButt.DELETE_ACCOUNT },
					null)) {
			case EXIT:return;
			case ACCOUNT:
				acb = new AccountBean();
				acb.setName(JOptionPane.showInputDialog("이름"));
				acb.setUid(JOptionPane.showInputDialog("아이디"));
				acb.setPass(JOptionPane.showInputDialog("패스워드"));
				service.createAccountBean(acb);
				break;
			case MINUSACCOUNT:
				acb = new MinusAccountBean();
				acb.setName(JOptionPane.showInputDialog("이름"));
				acb.setUid(JOptionPane.showInputDialog("아이디"));
				acb.setPass(JOptionPane.showInputDialog("패스워드"));
				((MinusAccountBean) acb).setLimit(JOptionPane.showInputDialog("한도"));
				((MinusAccountServiceImpl) service).createMinusAccountBean(acb);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_ID:
				/*
				 ID 와 PASS 받아서 일치하면
				 계좌내역을 보여줘. 단, 혹시 모르니까 비번은 **** 처리해
				 */
				acb = new AccountBean();
				acb.setUid(JOptionPane.showInputDialog("아이디"));
				acb.setPass(JOptionPane.showInputDialog("패스워드"));
				JOptionPane.showMessageDialog(null,service.findById(acb));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
				break;
			case MINUS_LIST:
				JOptionPane.showMessageDialog(null,((MinusAccountServiceImpl) service).minusList());
			case CHANGE_PASS:
				acb = new AccountBean();
				acb.setUid(JOptionPane.showInputDialog("아이디"));
				acb.setPass(JOptionPane.showInputDialog("패스워드")
						+
						"/"
						+
						JOptionPane.showInputDialog("새로운비밀번호"));
				JOptionPane.showMessageDialog(null,service.changePass(acb));
				break;
			case DELETE_ACCOUNT:
				acb = new AccountBean();
				acb.setUid(JOptionPane.showInputDialog("아이디"));
				acb.setPass(JOptionPane.showInputDialog("패스워드")
						+
						"/"
						+
						JOptionPane.showInputDialog("패스워드확인"));
				//계좌삭제후 총계좌수가 1 감소해야함
				JOptionPane.showMessageDialog(null,service.dropAccount(acb));
				break;
			default:break;
			}
		}
	}

}
