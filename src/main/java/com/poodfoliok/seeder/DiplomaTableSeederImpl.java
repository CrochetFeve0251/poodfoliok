package com.poodfoliok.seeder;


import com.poodfoliok.factory.DiplomaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class DiplomaTableSeederImpl implements DiplomaTableSeeder {
    @Autowired
    protected DiplomaFactory diplomaFactory;

    @Override
    public void seed() {
        diplomaFactory.create(20);
    }
}
