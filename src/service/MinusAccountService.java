package service;

import domain.*;

public interface MinusAccountService extends AccountService {
	public void createMinusAccountBean(AccountBean minusAccountBean);
	public void addList(MinusAccountBean minusAccountBean);
	public AccountBean[] minusList();
	
}
