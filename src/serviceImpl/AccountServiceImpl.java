package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService{
	protected AccountBean[] list;
	protected int count;
	
	public AccountServiceImpl(){
		list = new AccountBean[5];
		count = 0;
	}
	@Override
	public void createAccountBean(AccountBean accountBean) {
		accountBean.setAccountType("기본통장");
		accountBean.setAccountNo(createAccountNum(""));
		accountBean.setCreateDate(createDate());
		addList(accountBean);
	}
	
	@Override
	public void addList(AccountBean accountBean) {
		list[count++] = accountBean;
	}

	@Override
	public AccountBean[] list() {
		System.out.println(count);
		String res = "";
		for(int i=0;i<list.length;i++) {
			res += list[i] + "\n";
		}
		System.out.println(res);
		return list;
	}

	@Override
	public void deposit(String money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(String money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String createAccountNum(String random) {
		String accountNo = "";
		String op = "-";
		for (int i = 0; i < 3; i++) {
			if (i == 2) {
				op = "";
			}
			accountNo += createRandom(0,999) + op;
		}
		return accountNo;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.format("%03d", start + ((int)(Math.random() * (end-(start-1)))));
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date());
	}
	@Override
	public AccountBean findById(AccountBean accountBean) {
		//배열 list를 looping 하면서 id가 일치하고 비번이 일치한 값을 찾아서 그 객체를 리턴한다.
		//일단 일치하는 값이 없는 상황은 나중에 처리
		AccountBean ac = new AccountBean();
		for(int i=0;i<count;i++) {
			if((accountBean.getUid().equals(list[i].getUid()) && (accountBean.getPass().equals(list[i].getPass())))) {
				 ac = list[i];
				 break;
			}
		}
		return ac;
	}
	@Override
	public AccountBean[] findByName(String name) {
		int nameCount = countSameWord(name);
		AccountBean[] arr = new AccountBean[nameCount];
		for(int i=0, nameIndex=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				arr[nameIndex++] = list[i];
				if(nameIndex == nameCount) {
					break;
				}
			}
		}
		return arr;
	}
	
	public int countSameWord(String name) {
		int num = 0;
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				num++;
			}
		}
		return num;
	}
	@Override
	public String changePass(AccountBean acb) {
		String msg = "";
		//성공 : 변경완료
		//실패 : 변경실패,똑같은 비번치면 실패
		String pass = acb.getPass().split("/")[0];
		String newPass = acb.getPass().split("/")[1];
		acb.setPass(pass);
		acb = findById(acb);
		if(acb.getName() == null) {
			msg = "없는계좌";
		}else if(pass.equals(newPass)){
			msg = "변경실패";
		}else{
			acb.setPass(newPass);
			msg = "변경완료";
		}
		return msg;
	}
	@Override
	public String dropAccount(AccountBean acb) {
		String msg = "";
		String pass = acb.getPass().split("/")[0];
		String confirmPass = acb.getPass().split("/")[1];
		int index = -1;
		if(pass.equals(confirmPass)) {
			acb.setPass(pass);
			acb = findById(acb);
			if(acb.getUid() == null) {
				msg = "없는계좌";
			}else {
				for(int i=0;i<count;i++) {
					if((acb.getUid().equals(list[i].getUid()) && (acb.getPass().equals(list[i].getPass())))) { 
						list[i] = list[--count];
						list[count] = null;
						msg = "계좌삭제완료";
						break;
					}
				}
				
				/*for(int i=0;i<count;i++) {
					if(index != -1) {
						if(i == count-1) {
							list[i]=null;
							break;
						}else {
							list[i] = list[i+1];
							continue;
						}
					}else {
						if((acb.getUid().equals(list[i].getUid()) && (acb.getPass().equals(list[i].getPass())))) { 
							index = i;
							i--;
						}
					}
				}
				msg = "계좌삭제완료";
				count--;*/
			}
		}else {
			msg = "비밀번호가 다릅니다.";
		}
		return msg;
	}
}
