package com.surplus.task.dto;

import java.util.List;

import com.surplus.task.domain.ImageModel;


public class ImagesResponse {
	
	private boolean status;	

	private String message;
	
	List<ImageModel> images;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ImageModel> getImages() {
		return images;
	}

	public void setImages(List<ImageModel> images) {
		this.images = images;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "ProductsResponse [status=" + status + ", message=" + message + ", images=" + images + "]";
	}


}
