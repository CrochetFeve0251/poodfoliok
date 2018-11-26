package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Integer> {
	
}