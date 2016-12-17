package entity;

public class Gift {
	private String giftid;
	private String giftname;
	private String giftimg;
	private int giftintegral;

	public Gift() {
	}

	public Gift(String giftid, String giftname, String giftimg, int giftintegral) {
		super();
		this.giftid = giftid;
		this.giftname = giftname;
		this.giftimg = giftimg;
		this.giftintegral = giftintegral;
	}

	public String getGiftid() {
		return giftid;
	}

	public void setGiftid(String giftid) {
		this.giftid = giftid;
	}

	public String getGiftname() {
		return giftname;
	}

	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}

	public String getGiftimg() {
		return giftimg;
	}

	public void setGiftimg(String giftimg) {
		this.giftimg = giftimg;
	}

	public int getGiftintegral() {
		return giftintegral;
	}

	public void setGiftintegral(int giftintegral) {
		this.giftintegral = giftintegral;
	}

}
