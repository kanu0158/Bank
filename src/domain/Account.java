package domain;

public class Account {
	public final static String BANK_NAME="비트뱅크";
	public final static String ACCOUNT_TYPE="기본통장";
	public final static String WITHDRAW_SUCCESS="출금성공";
	public final static String WITHDRAW_FAIL="잔액부족";
	public final static String DEPOSIT_SUCCESS="입금성공";
	public final static String DEPOSIT_FAIL="적합한 입력값이 아님";
	protected int money;// 잔액, 계좌 랜덤
	protected String name,accountNo,uid,pass,accountType,createDate;//uid는 아이디 , createDate는 계좌생성일 블로그에서 오늘날짜 뽑는 로직 가져다쓰세요.
	// 통장 123-345-678 의 형태가 되도록 코딩 math.random()이용해서
}
