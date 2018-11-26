package com.poodfoliok.seeder;

import com.poodfoliok.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class UserTableSeederImpl implements UserTableSeeder {

    @Autowired
    protected UserFactory userFactory;

    @Override
    public void seed() {
        userFactory.create(20);
    }
}
