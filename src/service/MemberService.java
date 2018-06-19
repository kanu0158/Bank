package service;

import domain.MemberBean;

public interface MemberService {

	public void createMemberBean(MemberBean mb);
	public void createUserBean(MemberBean mb);
	public void createStaffBean(MemberBean mb);
	public void addList(MemberBean mb);
	public MemberBean[] list();
	public MemberBean findById(MemberBean mb);
	public MemberBean[] findByName(String name);
	public int equalsWordNo(String name);
	public String count();
	public String upDatePass(MemberBean mb);
	public String dropMemberBean(MemberBean mb);

}
