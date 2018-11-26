package com.poodfoliok.seeder;

import com.poodfoliok.factory.CompanyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class CompanyTableSeederImpl implements CompanyTableSeeder {
    @Autowired
    protected CompanyFactory companyFactory;

    @Override
    public void seed() {
        companyFactory.create(100);
    }
}
