package service;

import domain.*;

public interface MinusAccountService extends AccountService {
	public MinusAccount createMinusAccount(String name,String uid,String pass);
	public void addList(MinusAccount minusAccount);
}
