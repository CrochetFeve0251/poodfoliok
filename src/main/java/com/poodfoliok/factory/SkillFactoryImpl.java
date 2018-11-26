package com.poodfoliok.factory;

import com.poodfoliok.model.Skill;
import com.poodfoliok.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class SkillFactoryImpl extends EntityFactoryImpl implements SkillFactory {
    @Autowired
    protected SkillRepository skillRepository;

    @Override
    public void create(int instances) {
        for(int i = 0; i < instances; i ++){
            Skill skill = new Skill();
            skill.setName(faker.job().keySkills());
            skill.setDescription(faker.lorem().paragraph());
            skillRepository.save(skill);
        }
    }
}
