package controller;
import javax.swing.JOptionPane;

import controller.AccountController.AccountButt;
import domain.*;
import service.*;
import serviceImpl.*;

enum MemberButt {
		EXIT,//JOIN은 일반유저 추가, ADD는 직원 추가
		JOIN,ADD,//값을 객체안에 생성 -> CREATE(추가)하는 메소드 
		LIST,FIND_BY_ID,FIND_BY_NAME,COUNT,//조건 혹은 조건이없을때 여러개값 또는 한개의 값을 리턴하는 ALL(전부리턴) ONE(하나) SOME(일부) --> READ(검색)하는 메소드
		UPDATE,// UPDATE수정하는 메소드 
		WITHDRAWAL; // DELETE삭제하는 메소드  ===> 앞글자만 따서 CRUD를 한다고 함 알아서짜라고하면 이런 형태가 기본
}
public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean mb = null; 
		while(true) {
			switch((MemberButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new MemberButt[] { MemberButt.EXIT,MemberButt.JOIN,MemberButt.ADD, MemberButt.LIST, MemberButt.FIND_BY_ID, MemberButt.FIND_BY_NAME,MemberButt.COUNT, MemberButt.UPDATE,  MemberButt.WITHDRAWAL},
					null)) {
			case EXIT:return;
			
			case JOIN:
				mb = new UserBean();
				mb.setName(JOptionPane.showInputDialog("이름"));
				mb.setUid(JOptionPane.showInputDialog("아이디"));
				mb.setPass(JOptionPane.showInputDialog("패스워드"));
				mb.setSsn(JOptionPane.showInputDialog("주민번호"));
				mb.setAddr(JOptionPane.showInputDialog("주소"));
				mb.setPhone(JOptionPane.showInputDialog("폰번호"));
				service.createUserBean(mb);
				break;
			case ADD:
				mb = new StaffBean();
				mb.setName(JOptionPane.showInputDialog("이름"));
				mb.setUid(JOptionPane.showInputDialog("아이디"));
				mb.setPass(JOptionPane.showInputDialog("패스워드"));
				mb.setSsn(JOptionPane.showInputDialog("주민번호"));
				mb.setAddr(JOptionPane.showInputDialog("주소"));
				mb.setPhone(JOptionPane.showInputDialog("폰번호"));
				service.createStaffBean(mb);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_BY_ID:
				/*
				 ID 와 PASS 받아서 일치하면
				 계좌내역을 보여줘. 단, 혹시 모르니까 비번은 **** 처리해
				 */
				mb = new MemberBean();
				mb.setUid(JOptionPane.showInputDialog("아이디"));
				mb.setPass(JOptionPane.showInputDialog("패스워드"));
				JOptionPane.showMessageDialog(null,service.findById(mb));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.count());
				break;
			case UPDATE:
				mb = new MemberBean();
				mb.setUid(JOptionPane.showInputDialog("아이디"));
				mb.setPass(JOptionPane.showInputDialog("패스워드")
						+
						"/"
						+
						JOptionPane.showInputDialog("새 패스워드"));
				JOptionPane.showMessageDialog(null,service.upDatePass(mb));
				break;
			case WITHDRAWAL:
				mb = new MemberBean();
				mb.setUid(JOptionPane.showInputDialog("아이디"));
				mb.setPass(JOptionPane.showInputDialog("패스워드")
						+
						"/"
						+
						JOptionPane.showInputDialog("패스워드 확인")
						);
				JOptionPane.showMessageDialog(null, service.dropMemberBean(mb));
				break;
			default:break;
			}
		}
	}
}
