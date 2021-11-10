package com.quangduy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quangduy.entity.CategoryEntity;
import com.quangduy.repository.CategoryRepository;
import com.quangduy.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository repository;
	@Override
	public CategoryEntity findOneByCode(String code) {

		return repository.findOneByCode(code);
	}
	
}
