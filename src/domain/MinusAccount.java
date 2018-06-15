package domain;

public class MinusAccount extends Account {
	public final static String ACCOUNT_TYPE="마이너스통장";
	public MinusAccount(String name, String uid, String pass) {
		super(name,uid,pass);
		setAccountType(ACCOUNT_TYPE);
	}
}
