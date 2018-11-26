package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.Diploma;
import com.poodfoliok.repository.DiplomaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DiplomaService {

	@Autowired
	private DiplomaRepository diplomaRepository;

	public List<Diploma> findAll() {
		return diplomaRepository.findAll();
	}

	public Diploma findOne(Integer id) {
		Optional<Diploma> optDiploma = diplomaRepository.findById(id);
		if (optDiploma.isPresent()) {
			return optDiploma.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public Diploma save(Diploma entity) {
		return diplomaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Diploma entity) {
		diplomaRepository.delete(entity);
	}

}
	
