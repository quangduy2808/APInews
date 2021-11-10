package com.quangduy.service;

import com.quangduy.entity.CategoryEntity;

public interface ICategoryService {
	CategoryEntity findOneByCode(String code);
}
