package com.poodfoliok.seeder;

import com.poodfoliok.factory.SocialMediaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class SocialMediaTableSeederImpl implements SocialMediaTableSeeder {
    @Autowired
    protected SocialMediaFactory socialMediaFactory;

    @Override
    public void seed() {
        socialMediaFactory.create(20);
    }
}
