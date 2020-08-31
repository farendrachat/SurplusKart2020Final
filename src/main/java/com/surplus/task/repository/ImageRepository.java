package com.surplus.task.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.surplus.task.domain.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel,Integer>
{

	public Iterable<ImageModel> findImageModelById(Integer id);
}
