package com.poodfoliok.factory;

import com.poodfoliok.model.SocialMedia;
import com.poodfoliok.repository.SocialMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class SocialMediaFactoryImpl extends EntityFactoryImpl implements SocialMediaFactory{
    @Autowired
    protected SocialMediaRepository socialMediaRepository;

    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            SocialMedia socialMedia = new SocialMedia();
            socialMedia.setName(faker.app().name());
            socialMedia.setDescription(faker.lorem().paragraph());
            socialMedia.setImage(faker.avatar().image());
            socialMediaRepository.save(socialMedia);
        }
    }
}
