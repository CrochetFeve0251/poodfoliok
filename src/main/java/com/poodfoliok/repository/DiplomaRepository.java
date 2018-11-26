package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.Diploma;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Integer> {
	
}