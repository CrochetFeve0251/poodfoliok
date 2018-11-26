package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.Hobby;
import com.poodfoliok.repository.HobbyRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class HobbyService {

	@Autowired
	private HobbyRepository hobbyRepository;

	public List<Hobby> findAll() {
		return hobbyRepository.findAll();
	}

	public Hobby findOne(Integer id) {
		Optional<Hobby> optHobby = hobbyRepository.findById(id);
		if (optHobby.isPresent()) {
			return optHobby.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public Hobby save(Hobby entity) {
		return hobbyRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Hobby entity) {
		hobbyRepository.delete(entity);
	}

}
	
