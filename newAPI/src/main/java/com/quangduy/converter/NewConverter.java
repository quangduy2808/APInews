package com.quangduy.converter;

import org.springframework.stereotype.Component;

import com.quangduy.dto.NewDTO;
import com.quangduy.entity.NewEntity;

@Component
public class NewConverter {
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		dto.setTitle(entity.getTitle());
		dto.setThumbnail(entity.getThumbnail());
		dto.setShortDescription(entity.getShortDescription());
		dto.setContent(entity.getContent());
		dto.setId(entity.getId());
		dto.setCreateBy(entity.getCreateBy());
		dto.setCreateDate(entity.getCreateDate());
		dto.setLastModifyBy(entity.getLastmodifiedBy());
		dto.setLastModifyDate(entity.getLastModifiedDate());
		dto.setCategory(entity.getCategory().getCode());
		return dto;
		
	}
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		
		entity.setTitle(dto.getTitle());
		entity.setThumbnail(dto.getThumbnail());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		return entity;
	}
}
