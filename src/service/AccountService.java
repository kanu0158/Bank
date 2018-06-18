package service;

import domain.AccountBean;

public interface AccountService {
	public void createAccountBean(AccountBean accountBean);
	public void addList(AccountBean accountBean);
	public AccountBean[] list();
	public void deposit(String money);//추상메소드 선언! setget은 달지않는다 헷갈려 대신 동사로 작성, 합치는기능은 얘가하고 즉 계산만 하고 값은 setmoney에게 전달해줘, 필드가 없기때문에 인터페이스는 저장안해,따라서 리턴값 무조건 존재
	public void withdraw(String money);
	public String createAccountNum(String random);// 최대한 한기능만 하도록 세분화
	public String createRandom(int start, int end);
	public String createDate();
	public AccountBean findById(AccountBean accountBean);
	public AccountBean[] findByName(String name);
	public int countSameWord(String word);
}
