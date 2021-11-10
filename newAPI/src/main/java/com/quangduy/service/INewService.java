package com.quangduy.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.quangduy.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO dto);
	void deleteById(long id);
	List<NewDTO> findAll(Pageable pageabless);
	Long totalNew();
	}
