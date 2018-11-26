package com.poodfoliok.factory;

import com.poodfoliok.model.Project;
import com.poodfoliok.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class ProjectFactoryImpl extends EntityFactoryImpl implements ProjectFactory {
    @Autowired
    protected ProjectRepository projectRepository;

    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            Project project = new Project();
            project.setName(faker.job().position());
            project.setDescription(faker.lorem().paragraph());
            project.setEnd(faker.date().birthday());
            project.setStart(faker.date().birthday());
            project.setImage(faker.avatar().image());
            project.setLink(faker.internet().url());
            projectRepository.save(project);
        }
    }
}
