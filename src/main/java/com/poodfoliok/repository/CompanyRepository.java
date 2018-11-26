package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
}