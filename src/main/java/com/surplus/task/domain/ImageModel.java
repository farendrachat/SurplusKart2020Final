package com.surplus.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="image_model")
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    
    @Column(name="productId")
    private String productId;

    @Column(name = "ImageName")
    private String imageName;
    
    @Column(name = "picType")
    private String picType;

    @Column(name = "imageType")
    private String imageType;

    @Lob
    @Column(name = "pic")
    private byte[] pic;

//Custom Construtor
    public ImageModel(String productId,String imageName, String picType,String imageType, byte[] pic) {
    	 this.productId = productId;
    	 this.imageName = imageName;
         this.picType = picType;
         this.imageType = imageType;
        this.pic = pic;
    }
}