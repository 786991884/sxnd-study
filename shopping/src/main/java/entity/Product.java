package entity;

import java.util.Date;

public class Product {
	private String prodid;
	private String prodname;
	private Date putawaytime;
	private String isspecial;
	private String isfashion;
	private double prodprice;
	private String prodimg;
	private String prodtype;

	public Product() {
	}

	public Product(String prodid, String prodname, Date putawaytime,
			String isspecial, String isfashion, double prodprice, String prodimg) {
		super();
		this.prodid = prodid;
		this.prodname = prodname;
		this.putawaytime = putawaytime;
		this.isspecial = isspecial;
		this.isfashion = isfashion;
		this.prodprice = prodprice;
		this.prodimg = prodimg;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public Date getPutawaytime() {
		return putawaytime;
	}

	public void setPutawaytime(Date putawaytime) {
		this.putawaytime = putawaytime;
	}

	public String getIsspecial() {
		return isspecial;
	}

	public void setIsspecial(String isspecial) {
		this.isspecial = isspecial;
	}

	public String getIsfashion() {
		return isfashion;
	}

	public void setIsfashion(String isfashion) {
		this.isfashion = isfashion;
	}

	public double getProdprice() {
		return prodprice;
	}

	public void setProdprice(double prodprice) {
		this.prodprice = prodprice;
	}

	public String getProdimg() {
		return prodimg;
	}

	public void setProdimg(String prodimg) {
		this.prodimg = prodimg;
	}

	public String getProdtype() {
		return prodtype;
	}

	public void setProdtype(String prodtype) {
		this.prodtype = prodtype;
	}

}
