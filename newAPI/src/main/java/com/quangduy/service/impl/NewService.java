package com.quangduy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quangduy.converter.NewConverter;
import com.quangduy.dto.NewDTO;
import com.quangduy.entity.CategoryEntity;
import com.quangduy.entity.NewEntity;
import com.quangduy.repository.NewRepository;
import com.quangduy.service.ICategoryService;
import com.quangduy.service.INewService;

@Service
public class NewService implements INewService{
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO dto) {
		CategoryEntity categoryEntity = categoryService.findOneByCode(dto.getCategory());
		NewEntity entity = new NewEntity();
		if(dto.getId()!= null) {
			 entity = newConverter.toEntity(dto, newRepository.findOneById(dto.getId()));
		}else {
			 entity = newConverter.toEntity(dto);
		}
		entity.setCategory(categoryEntity);
		return newConverter.toDTO(newRepository.save(entity));
	}

	@Override
	public void deleteById(long id) {
		newRepository.deleteById(id);
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewEntity> list =  newRepository.findAll(pageable).getContent();
		List<NewDTO> listDTO = new ArrayList<NewDTO>();
		for (NewEntity newEntity : list) {
			listDTO.add(newConverter.toDTO(newEntity));
		}
		return listDTO;
	}

	@Override
	public Long totalNew() {
		
		return newRepository.count();
	}
	
}
