package cn.sm1234.domain;

public class CustomerRM {

	private Integer custId;
	private String custName;
	private String custGender;
	private String custTelephone;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustGender() {
		return custGender;
	}
	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}
	public String getCustTelephone() {
		return custTelephone;
	}
	public void setCustTelephone(String custTelephone) {
		this.custTelephone = custTelephone;
	}
	@Override
	public String toString() {
		return "CustomerRM [custId=" + custId + ", custName=" + custName
				+ ", custGender=" + custGender + ", custTelephone="
				+ custTelephone + "]";
	}
	
}
