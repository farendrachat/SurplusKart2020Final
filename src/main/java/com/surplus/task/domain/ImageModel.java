package com.surplus.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="image_model")
@AllArgsConstructor
//@Data
@NoArgsConstructor
@ToString
public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Column(name="prId")
    private Integer productId;

    @Column(name = "ImageName")
    private String imageName;
    
    @Column(name = "picType")
    private String picType;

    @Column(name = "imageType")
    private String imageType;

    @Lob
    @Column(name = "pic")
    private byte[] pic;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	
    
//    public ImageModel() {
//   }

//Custom Construtor
    public ImageModel(Integer productId,String imageName, String picType,String imageType, byte[] pic) {
    	 this.productId = productId;
    	 this.imageName = imageName;
         this.picType = picType;
         this.imageType = imageType;
        this.pic = pic;
    }
}