package com.poodfoliok.factory;

import com.poodfoliok.model.Hobby;
import com.poodfoliok.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class HobbyFactoryImpl extends EntityFactoryImpl implements HobbyFactory {
    @Autowired
    protected HobbyRepository hobbyRepository;
    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            Hobby hobby = new Hobby();
            hobby.setName(faker.music().instrument());
            hobby.setDescription(faker.lorem().paragraph());
            hobby.setImage(faker.avatar().image());
            hobbyRepository.save(hobby);
        }
    }
}
