package com.poodfoliok.seeder;

import com.poodfoliok.factory.SchoolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class SchoolTableSeederImpl implements SchoolTableSeeder {
    @Autowired
    protected SchoolFactory schoolFactory;

    @Override
    public void seed() {
        schoolFactory.create(20);
    }
}
