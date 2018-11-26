package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
}