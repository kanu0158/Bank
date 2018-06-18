package domain;

public class OwnerSalary extends StaffSalary {
	protected int share;
	public void setShare(int share) {
		this.share = share;
	}
	public int getShare() {
		return share;
	}
	@Override
	public String toString() {
		return String.format("%s | %d | %d | %d |\n", getName().substring(0,1)+getDept().substring(0,2),getSal(),getBonus(),getShare());
	}
}
