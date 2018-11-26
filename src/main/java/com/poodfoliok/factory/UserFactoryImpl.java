package com.poodfoliok.factory;

import com.poodfoliok.model.User;
import com.poodfoliok.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class UserFactoryImpl extends EntityFactoryImpl implements UserFactory {
    @Autowired
    protected UserRepository userRepository;

    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            User user = new User();
            user.setFirstname(faker.name().firstName());
            user.setLastname(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setUsername(faker.name().username());
            String password = faker.internet().password();
            user.setPassword(password);
            user.setPasswordConfirm(password);
            userRepository.save(user);
        }
    }
}
