package com.poodfoliok.seeder;

import com.poodfoliok.factory.SkillFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class SkillTableSeederImpl implements SkillTableSeeder {
    @Autowired
    protected SkillFactory skillFactory;

    @Override
    public void seed() {
        skillFactory.create(10);
    }
}
