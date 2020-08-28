package com.surplus.task.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;

@Entity
public class Product {

	@Column(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int prId;
	
	@Column(nullable = false)
	protected String name;

	@Column(nullable = false)
	protected String category;

//	@Column(nullable = false)
	protected int sellerId;

	protected double availableQty;

//	@Column(nullable = false)
	protected String identity;	

	@Column(nullable = false)
	protected String qtyExpressed;

	protected double unitPrice;

	/*
	 *  inserting and fetching BLOB data such as images requires two steps: 
	 *  a>define database column type as “BLOB” and 
	 *  b>have a field in entity of type “byte array”.
	 *  Strings are mapped to database type CLOB and byte[] to BLOB
	 */
	@Lob
   // @Column(name = "IMAGE")	
	protected  byte[] pic1;

	protected byte[] pic2;

	protected byte[] pic3;

	protected byte[] coa;

	protected double remainQty;

	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date updateOn;

	//@Column(nullable = false)
	protected int loadedBy;

//	@Column(nullable = false)
	protected boolean approved;

	@Column(nullable = false)
	protected int approvedBy;	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public Product() {
		super();
	}
	
	public byte[] getCoa() {
		return coa;
	}

	public void setCoa(byte[] coa) {
		this.coa = coa;
	}

	public int getPrId() {
		return this.prId;
	}

	public String getCategory() {
		return this.category;
	}

	public int getSellerId() {
		return this.sellerId;
	}

	public double getAvailableQty() {
		return this.availableQty;
	}

	public String getQtyExpressed() {
		return this.qtyExpressed;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public byte[] getPic1() {
		return this.pic1;
	}

	public byte[] getPic2() {
		return this.pic2;
	}

	public byte[] getPic3() {
		return this.pic3;
	}



	public double getRemainQty() {
		return this.remainQty;
	}

	public Date getUpdateOn() {
		return this.updateOn;
	}

	public int getLoadedBy() {
		return this.loadedBy;
	}

	public boolean isApproved() {
		return this.approved;
	}

	public int getApprovedBy() {
		return this.approvedBy;
	}

	

	public void setPrId(int myPrId) {
		this.prId = myPrId;
	}

	public void setCategory(String myCategory) {
		this.category = myCategory;
	}

	public void setSellerId(int mySellerId) {
		this.sellerId = mySellerId;
	}

	public void setAvailableQty(double myAvailableQty) {
		this.availableQty = myAvailableQty;
	}

	public void setQtyExpressed(String myQtyExpressed) {
		this.qtyExpressed = myQtyExpressed;
	}

	public void setUnitPrice(double myUnitPrice) {
		this.unitPrice = myUnitPrice;
	}

	public void setPic1(byte[] myPic1) {
		this.pic1 = myPic1;
	}

	public void setPic2(byte[] myPic2) {
		this.pic2 = myPic2;
	}

	public void setPic3(byte[] myPic3) {
		this.pic3 = myPic3;
	}

	public void setRemainQty(double myRemainQty) {
		this.remainQty = myRemainQty;
	}

	public void setUpdateOn(Date myUpdateOn) {
		this.updateOn = myUpdateOn;
	}

	public void setLoadedBy(int myLoadedBy) {
		this.loadedBy = myLoadedBy;
	}

	public void setApproved(boolean myApproved) {
		this.approved = myApproved;
	}

	public void setApprovedBy(int myApprovedBy) {
		this.approvedBy = myApprovedBy;
	}

}
