package com.quangduy.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quangduy.dto.NewDTO;
import com.quangduy.service.INewService;

@RestController
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@GetMapping("/newAPI")
	public NewDTO showNew(@RequestParam("page") int page, @RequestParam("limit") int limit){
		NewDTO dto = new NewDTO();
		Pageable pageable = PageRequest.of(page - 1, limit);
		dto.setListResult(newService.findAll(pageable));
		dto.setPage(page);
		dto.setLimit(limit);
		dto.setTotalPage((int)Math.ceil(newService.totalNew()/limit));
		return dto;
	}
	@PostMapping("/newAPI")
	public NewDTO insert(@RequestBody NewDTO dto) {
		return newService.save(dto);
	}

	@PutMapping("/newAPI")
	public NewDTO updateOrUpdate(@RequestBody NewDTO dto) {
		return newService.save(dto);
	}
	
	@DeleteMapping("/newAPI")
	public void delete (@RequestBody Long[] ids) {
		for (Long id : ids) {
			newService.deleteById(id);
		}
	}

}