package com.surplus.task.domain;

import java.sql.Date;

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
	protected String identity;	
	protected String state;		
	protected String city;	
	protected String brand;	
	protected String qtyExpressed;	
	
	protected int sellerId;
	protected int buyerId;	
	
	protected double availableQty;
	protected double unitPrice;
	protected double packSize;
	protected double remainQty;

	/*
	 *  inserting and fetching BLOB data such as images requires two steps: 
	 *  a>define database column type as “BLOB” and 
	 *  b>have a field in entity of type “byte array”.
	 *  Strings are mapped to database type CLOB and byte[] to BLOB
	 */
	@Lob
   // @Column(name = "IMAGE")	
	protected byte[] pic1;
	protected byte[] pic2;
	protected byte[] pic3;
	protected byte[] coa;
	
	protected Date dateManufacture;	
	protected Date dateExpire;
	//@Temporal(javax.persistence.TemporalType.DATE)
	protected Date updateOn;
	protected int loadedBy;
	protected boolean approved;
	protected int approvedBy;	
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}	
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getQtyExpressed() {
		return qtyExpressed;
	}
	public void setQtyExpressed(String qtyExpressed) {
		this.qtyExpressed = qtyExpressed;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public double getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getPackSize() {
		return packSize;
	}
	public void setPackSize(double packSize) {
		this.packSize = packSize;
	}
	public double getRemainQty() {
		return remainQty;
	}
	public void setRemainQty(double remainQty) {
		this.remainQty = remainQty;
	}
	public byte[] getCoa() {
		return coa;
	}
	public void setCoa(byte[] coa) {
		this.coa = coa;
	}
	public Date getDateManufacture() {
		return dateManufacture;
	}
	public void setDateManufacture(Date dateManufacture) {
		this.dateManufacture = dateManufacture;
	}
	public Date getDateExpire() {
		return dateExpire;
	}
	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public int getLoadedBy() {
		return loadedBy;
	}
	public void setLoadedBy(int loadedBy) {
		this.loadedBy = loadedBy;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
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
	public void setPic1(byte[] myPic1) {
		this.pic1 = myPic1;
	}
	public void setPic2(byte[] myPic2) {
		this.pic2 = myPic2;
	}
	public void setPic3(byte[] myPic3) {
		this.pic3 = myPic3;
	}

}
