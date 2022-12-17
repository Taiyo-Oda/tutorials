package issue;

public class ElectricityBill {

	private int meterNum;
	private String name;
	private String address;

	public int getMeterNum() {
		return meterNum;
	}

	public void setMeterNum(int meterNum) {
		this.meterNum = meterNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "meterNum:" + this.meterNum + " name:" + this.name + " addres:" + this.address;
	}

	@Override
	public boolean equals(Object obj) {
		ElectricityBill eb = (ElectricityBill) obj;
		if (eb.getMeterNum() == this.meterNum && eb.getName().equals(this.name)
				&& eb.getAddress().equals(this.address)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.meterNum;
	}

}
