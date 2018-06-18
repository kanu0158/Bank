package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.*;

public class AccountServiceImpl implements AccountService{
	protected Account[] list;
	protected int count;
	
	public AccountServiceImpl(){
		list = new Account[100];
		count = 0;
	}
	@Override
	public Account createAccount(String name, String uid, String pass) {
		Account ac = new Account();
		ac.setName(name);
		ac.setUid(uid);
		ac.setPass(pass);
		ac.setAccountType("기본통장");
		ac.setAccountNo(createAccountNum(""));
		ac.setCreateDate(createDate());
		return ac;
	}
	
	@Override
	public void addList(Account account) {
		list[count++] = account;
		System.out.println(count);
	}

	@Override
	public Account[] list() {
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
	public String showResult() {
		String result = "";
		for(int i=0;i<count;i++) {
			result += list()[i].toString();
		}
		return result;
	}

}
