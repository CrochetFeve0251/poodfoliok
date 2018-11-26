package com.poodfoliok.factory;

import com.poodfoliok.model.School;
import com.poodfoliok.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class SchoolFactoryImpl extends EntityFactoryImpl implements SchoolFactory {

    @Autowired
    protected SchoolRepository schoolRepository;

    @Override
    public void create(int instances) {
        for(int i = 0; i < instances; i ++){
            School school = new School();
            school.setName(faker.educator().university());
            school.setDescription(faker.lorem().paragraph());
            school.setLink(faker.internet().url());
            school.setImage(faker.avatar().image());
            schoolRepository.save(school);
        }
    }
}
