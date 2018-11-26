package com.poodfoliok.seeder;

import com.poodfoliok.factory.ProjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class ProjectTableSeederImpl implements ProjectTableSeeder {
    @Autowired
    protected ProjectFactory projectFactory;

    @Override
    public void seed() {
        projectFactory.create(50);
    }
}
