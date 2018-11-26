package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.Skill;
import com.poodfoliok.repository.SkillRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public List<Skill> findAll() {
		return skillRepository.findAll();
	}

	public Skill findOne(Integer id) {
		Optional<Skill> optSkill = skillRepository.findById(id);
		if (optSkill.isPresent()) {
			return optSkill.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public Skill save(Skill entity) {
		return skillRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Skill entity) {
		skillRepository.delete(entity);
	}

}
	
