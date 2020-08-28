package com.surplus.task.service;

import java.util.List;

import com.surplus.task.domain.ImageModel;

public interface ImageService {

	Iterable<ImageModel> list();

	ImageModel save(ImageModel imageModel);

	ImageModel getImageModel(int productId);

	Iterable<ImageModel> getImageModelByProductId(int productId);

	boolean saveAll(List<ImageModel> mandatoryImages);
	

}
