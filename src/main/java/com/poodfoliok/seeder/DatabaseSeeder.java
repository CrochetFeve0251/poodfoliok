package com.poodfoliok.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by eisti on 26/11/18.
 */
@Component
public class DatabaseSeeder {

    @Autowired
    protected UserTableSeeder userTableSeeder;

    @Autowired
    protected CountryTableSeeder countryTableSeeder;

    @Autowired
    protected SkillTableSeeder skillTableSeeder;

    @Autowired
    protected SchoolTableSeeder schoolTableSeeder;

    @Autowired
    protected CompanyTableSeeder companyTableSeeder;

    @Autowired
    protected HobbyTableSeeder hobbyTableSeeder;

    @Autowired
    protected DiplomaTableSeeder diplomaTableSeeder;

    @Autowired
    protected ProjectTableSeeder projectTableSeeder;

    @Autowired
    protected SocialMediaTableSeeder socialMediaTableSeeder;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        userTableSeeder.seed();
        countryTableSeeder.seed();
        skillTableSeeder.seed();
        schoolTableSeeder.seed();
        countryTableSeeder.seed();
        companyTableSeeder.seed();
        hobbyTableSeeder.seed();
        diplomaTableSeeder.seed();
        projectTableSeeder.seed();
        socialMediaTableSeeder.seed();
    }
}
