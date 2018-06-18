package domain;

public class OwnerSalaryBean extends StaffSalaryBean {
	protected String share;
	public void setShare(String share) {
		this.share = share;
	}
	public String getShare() {
		return share;
	}
	@Override
	public String toString() {
		return String.format("%s | %s | %s | %s |\n", getName().substring(0,1)+getDept().substring(0,2),getSal(),getBonus(),getShare());
	}
}
