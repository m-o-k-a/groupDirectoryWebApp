package mybootapp.repo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import mybootapp.model.Group;
import mybootapp.model.Person;

@Configuration
@EntityScan(basePackageClasses = {Group.class, Person.class})
@EnableJpaRepositories(basePackageClasses = SpringDaoConfig.class)
public class SpringDaoConfig {

}