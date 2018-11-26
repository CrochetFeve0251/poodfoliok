package com.poodfoliok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.poodfoliok.model.SocialMedia;
import com.poodfoliok.repository.SocialMediaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SocialMediaService {

	@Autowired
	private SocialMediaRepository socialmediaRepository;

	public List<SocialMedia> findAll() {
		return socialmediaRepository.findAll();
	}

	public SocialMedia findOne(Integer id) {
		Optional<SocialMedia> optSocialMedia = socialmediaRepository.findById(id);
		if (optSocialMedia.isPresent()) {
			return optSocialMedia.get();
		} else {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public SocialMedia save(SocialMedia entity) {
		return socialmediaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(SocialMedia entity) {
		socialmediaRepository.delete(entity);
	}

}
	
