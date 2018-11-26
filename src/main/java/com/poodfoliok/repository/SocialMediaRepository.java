package com.poodfoliok.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poodfoliok.model.SocialMedia;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Integer> {
	
}