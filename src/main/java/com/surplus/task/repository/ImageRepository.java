package com.surplus.task.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel,Integer>
{

	public List<ImageModel> findImageModelByProductId(Integer productId);
}
