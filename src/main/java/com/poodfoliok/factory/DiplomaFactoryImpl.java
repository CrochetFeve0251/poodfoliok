package com.poodfoliok.factory;

import com.poodfoliok.model.Diploma;
import com.poodfoliok.repository.DiplomaRepository;
import com.poodfoliok.repository.SchoolRepository;
import com.poodfoliok.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by eisti on 26/11/18.
 */
@Service
public class DiplomaFactoryImpl extends EntityFactoryImpl implements DiplomaFactory{
    @Autowired
    protected DiplomaRepository diplomaRepository;

    @Autowired
    protected SchoolRepository schoolRepository;

    @Autowired
    protected UserRepository userRepository;

    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            Diploma diploma = new Diploma();
            diploma.setName(faker.university().name());
            diploma.setDate(faker.date().birthday());
            diploma.setSchool(schoolRepository.getOne(faker.random().nextInt(0,((int) schoolRepository.count()) - 1)));
            diploma.setUser(userRepository.getOne(faker.random().nextInt(0,((int) userRepository.count()) - 1)));
            diplomaRepository.save(diploma);
        }
    }
}
