package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import domain.*;
import service.*;

public class MinusAccountServiceImpl extends AccountServiceImpl implements MinusAccountService{
	protected int minusCount;
	public MinusAccountServiceImpl() {
		minusCount = 0;
	}
	@Override
	public void createMinusAccountBean(AccountBean minusAccountBean) {
		minusAccountBean.setAccountType("마이너스통장");
		minusAccountBean.setAccountNo(createAccountNum(""));
		minusAccountBean.setCreateDate(createDate());
		addList(minusAccountBean);
	}

	@Override
	public void addList(MinusAccountBean minusAccountBean) {
		list[super.count++] = minusAccountBean;
		minusCount++;
	}
	@Override
	public AccountBean[] minusList() {
		AccountBean[] marr = new MinusAccountBean[minusCount];
		for(int i=0,mi=0;i<super.count;i++) {
			if(list[i] instanceof MinusAccountBean) {
				marr[mi++] = list[i];
				if(mi==minusCount) {
					break;
				}
			}
		}
		return marr;
	}
}
