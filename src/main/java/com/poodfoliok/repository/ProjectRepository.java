package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
}