package com.cemcelik.pageable.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cemcelik.pageable.model.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	
	@Query(value = "from Personnel")
	Page<Personnel> findAllPagaable(Pageable pageable);

}
