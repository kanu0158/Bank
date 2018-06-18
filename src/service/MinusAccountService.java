package service;

import domain.*;

public interface MinusAccountService extends AccountService {
	public void createMinusAccountBean(AccountBean minusAccountBean);
	public void addList(AccountBean minusAccountBean);
	public AccountBean[] minusList();
	
}
