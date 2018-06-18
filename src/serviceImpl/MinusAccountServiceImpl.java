package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import domain.*;
import service.*;

public class MinusAccountServiceImpl extends AccountServiceImpl implements MinusAccountService{
	@Override
	public MinusAccount createMinusAccount(String name, String uid, String pass) {
		MinusAccount ma = new MinusAccount();
		ma.setName(name);
		ma.setUid(uid);
		ma.setPass(pass);
		ma.setAccountType("마이너스통장");
		ma.setAccountNo(createAccountNum(""));
		ma.setCreateDate(createDate());
		return ma;
	}

	@Override
	public void addList(MinusAccount minusAccount) {
		list[super.count++] = minusAccount;
		System.out.println(count);
	}	
}
