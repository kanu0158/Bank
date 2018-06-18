package domain;

public class MinusAccount extends Account {
	@Override
	public void setAccountType(String accountType) {
		super.setAccountType("마이너스통장");
	}

}
