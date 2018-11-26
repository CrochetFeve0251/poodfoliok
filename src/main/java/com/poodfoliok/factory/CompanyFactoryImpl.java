package com.poodfoliok.factory;

import com.poodfoliok.model.Company;
import com.poodfoliok.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class CompanyFactoryImpl extends EntityFactoryImpl implements CompanyFactory {
    @Autowired
    protected CompanyRepository companyRepository;

    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            Company company = new Company();
            company.setName(faker.company().name());
            company.setDescription(faker.lorem().paragraph());
            company.setImage(faker.avatar().image());
            company.setLink(faker.internet().url());
            companyRepository.save(company);
        }
    }
}
