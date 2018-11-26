package com.poodfoliok.seeder;

import com.poodfoliok.factory.HobbyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class HobbyTableSeederImpl implements HobbyTableSeeder {
    @Autowired
    protected HobbyFactory hobbyFactory;

    @Override
    public void seed() {
        hobbyFactory.create(20);
    }
}
