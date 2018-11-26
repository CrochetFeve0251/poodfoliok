package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}