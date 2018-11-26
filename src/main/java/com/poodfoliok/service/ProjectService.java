package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.Project;
import com.poodfoliok.repository.ProjectRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public Project findOne(Integer id) {
		Optional<Project> optProject = projectRepository.findById(id);
		if (optProject.isPresent()) {
			return optProject.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public Project save(Project entity) {
		return projectRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Project entity) {
		projectRepository.delete(entity);
	}

}
	
