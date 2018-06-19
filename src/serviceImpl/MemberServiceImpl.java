package serviceImpl;
import domain.*;
import service.*;

public class MemberServiceImpl implements MemberService{
	private MemberBean[] list;
	private int count;
	public MemberServiceImpl() {
		list = new MemberBean[50];
		count = 0;
	}
	@Override
	public void createMemberBean(MemberBean mb) {
		addList(mb);
	}
	@Override
	public void createUserBean(MemberBean mb) {
		((UserBean)mb).setCreditRate("7급");
		addList(mb);
	}
	@Override
	public void createStaffBean(MemberBean mb) {
		((StaffBean) mb).setAccessNum("1234");
		addList(mb);
	}
	@Override
	public void addList(MemberBean mb) {
		list[count++] = mb;		
	}
	@Override
	public MemberBean[] list() {
		return list;
	}
	@Override
	public MemberBean findById(MemberBean mb) {
		MemberBean memberBean = new MemberBean();
		for(int i=0;i<count;i++) {
			if(mb.getUid().equals(list[i].getUid()) && mb.getPass().equals(list[i].getPass())) {
				memberBean = list[i];
			}
		}
		return memberBean;
	}
	@Override
	public MemberBean[] findByName(String name) {
		int temp = equalsWordNo(name);
		int index = 0;
		MemberBean[] arr = new MemberBean[temp];
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				arr[index++] = list[i];
			}
		}
		return arr;
	}
	@Override
	public int equalsWordNo(String name) {
		int wordNum = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				wordNum++;
			}
		}
		return wordNum;
	}
	@Override
	public String count() {
		return String.valueOf((count));
	}
	@Override
	public String upDatePass(MemberBean mb) {
		String msg = "";
		String pass = mb.getPass().split("/")[0];
		String newPass = mb.getPass().split("/")[1];
		mb.setPass(pass);
		mb = findById(mb);
		if(mb.getUid() == null) {
			msg = "미가입멤버";
		}else {
			if(pass.equals(newPass)) {
				msg = "변경실패";
			}else {
				mb.setPass(newPass);
				msg = "변경완료";
			}
		}
		return msg;
	}
	@Override
	public String dropMemberBean(MemberBean mb) {
		String msg = "";
		String uid = mb.getUid();
		String pass = mb.getPass().split("/")[0];
		String confirmPass = mb.getPass().split("/")[1];
		mb.setPass(pass);
		mb = findById(mb);
		if(mb.getUid() == null) {
			msg = "미가입회원";
		}else {
			if(!pass.equals(confirmPass)) {
				msg = "비밀번호가틀렸습니다.";
			}else {
				for(int i=0;i<count;i++) {
					if(uid.equals(list[i].getUid()) && pass.equals(list[i].getPass())) {
						list[i] = list[--count];
						list[count]=null;
						msg = "회원탈퇴완료";
					}
				}
			}
		}
		return msg;
	}
	
	
	

}
