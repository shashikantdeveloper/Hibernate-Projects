package uni_one_to_one_2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {

	@Id
	private int id;
	private String pNo;
	private int pinCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

}
