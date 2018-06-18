package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService{
	protected AccountBean[] list;
	protected int count;
	
	public AccountServiceImpl(){
		list = new AccountBean[100];
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
}
