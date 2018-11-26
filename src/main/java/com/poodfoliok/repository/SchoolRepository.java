package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
	
}