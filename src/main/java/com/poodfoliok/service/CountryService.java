package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.Country;
import com.poodfoliok.repository.CountryRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	public Country findOne(Integer id) {
		Optional<Country> optCountry = countryRepository.findById(id);
		if (optCountry.isPresent()) {
			return optCountry.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public Country save(Country entity) {
		return countryRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Country entity) {
		countryRepository.delete(entity);
	}

}
	
