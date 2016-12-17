package entity;

public class ProductTypes {
	private String ptid;
	private String ptname;

	public ProductTypes() {
	}

	public ProductTypes(String ptid, String ptname) {
		super();
		this.ptid = ptid;
		this.ptname = ptname;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public String getPtname() {
		return ptname;
	}

	public void setPtname(String ptname) {
		this.ptname = ptname;
	}
}
