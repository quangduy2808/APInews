package com.quangduy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quangduy.entity.NewEntity;

@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long> {
	NewEntity findOneById(Long id);

	void deleteById(Long id);
}
