package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.School;
import com.poodfoliok.repository.SchoolRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	public List<School> findAll() {
		return schoolRepository.findAll();
	}

	public School findOne(Integer id) {
		Optional<School> optSchool = schoolRepository.findById(id);
		if (optSchool.isPresent()) {
			return optSchool.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public School save(School entity) {
		return schoolRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(School entity) {
		schoolRepository.delete(entity);
	}

}
	
