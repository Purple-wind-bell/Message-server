package chatting.vo;

/**
 * SP服务
 * 
 * @author Administrator
 *
 */
public class SP {
	/** SP服务ID */
	String ID;
	/** SP服务名称 */
	String name;
	/** SP服务费 */
	float charge;
	/** SP服务是否可用 */
	boolean avaiable;

	public SP() {
		super();
	}

	public SP(String iD, String name, float charge, boolean avaiable) {
		super();
		ID = iD;
		this.name = name;
		this.charge = charge;
		this.avaiable = avaiable;
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public float getCharge() {
		return charge;
	}

	public boolean isAvaiable() {
		return avaiable;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	public void setAvaiable(boolean avaiable) {
		this.avaiable = avaiable;
	}

}
