package com.surplus.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surplus.task.domain.ImageModel;
import com.surplus.task.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	ImageRepository imageRepository;
	
	ImageServiceImpl(ImageRepository imageRepository){
		this.imageRepository = imageRepository;		
	}

	@Override
	public Iterable<ImageModel> list() {
		return imageRepository.findAll();
	}

	@Override
	public ImageModel save(ImageModel imageModel) {
		//ImageModel imageModel = null;
		try{
			imageModel = this.imageRepository.save(imageModel);
		}catch(Exception ex)
		{
			System.out.println("exception in serviceIMpl is :"+ex.getMessage() );
		}
		return imageModel;
	}	
	
	public Iterable<ImageModel> deleteImageModel(int productId){
		ImageModel imageModel = null;
		Iterable<ImageModel> itrImageModel=null;
		try{
		//	Iterable<ImageModel> list  = this.imageRepository.findByProductId(productId);
		//for(int i =0;i<messageArr.length;i++){
		 this.imageRepository.delete(imageModel);
		 itrImageModel = imageRepository.findAll();		
		}catch(Exception ex)
		{
			System.out.println("exception is :"+ex);
			//messageArr[0]=null;
		}
		return itrImageModel;
	}



	@Override
	public Iterable<ImageModel> getImageModelByProductId(int productId) {
		Iterable<ImageModel> list = imageRepository.findImageModelById(productId);
		return list;
	}

	@Override
	public ImageModel getImageModel(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveAll(List<ImageModel> mandatoryImages) {		
		imageRepository.saveAll(mandatoryImages);
		return true;
		
	}
}
