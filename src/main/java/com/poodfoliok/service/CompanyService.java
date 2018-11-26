package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.Company;
import com.poodfoliok.repository.CompanyRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company findOne(Integer id) {
		Optional<Company> optCompany = companyRepository.findById(id);
		if (optCompany.isPresent()) {
			return optCompany.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public Company save(Company entity) {
		return companyRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Company entity) {
		companyRepository.delete(entity);
	}

}
	
