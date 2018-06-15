package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import domain.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	Account[] list;
	int count;
	public AccountServiceImpl() {
		this.count = 0;
	}
	@Override
	public Account createAccount(String name, String uid, String pass) {
		Account a = new Account();
		a.setName(name);
		a.setUid(uid);
		a.setPass(pass);
		a.setAccountNo(createAccountNum("999"));
		a.setCreateDate(createDate());
		return a;
	}

	@Override
	public void addList(Account account) {
		list[count++] = account;
	}

	@Override
	public Account[] list() {
		return list;
	}

	@Override
	public String createAccountNum(String random) {
		String accountNum = "";
		String op = "-";
		for(int i=0;i<3;i++) {
			if(i==2) {
				op = "";
			}
			accountNum += createRandom(0,Integer.parseInt(random)) + op;
		}
		return null;
	}

	@Override
	public String createRandom(int start, int end) {
		return String.format("%03d",(start + (int)(Math.random()*(end+1)))%1000);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
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
	public String showResult() {
		String result = "";
		for(int i=0;i<count;i++) {
			result += list()[i].toString();
		}
		return result;
	}

}
