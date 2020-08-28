package com.surplus.task.repository;

import org.springframework.data.repository.CrudRepository;

import com.surplus.task.domain.ImageModel;

public interface ImageRepository extends CrudRepository<ImageModel,Integer>
{

	public Iterable<ImageModel> findImageModelById(Integer id);
}
