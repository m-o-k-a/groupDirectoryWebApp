package mybootapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.web.Starter;
import mybootapp.model.Group;
import mybootapp.model.Person;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)
@Transactional
public class TestSimpleSettlement {
	
    @Autowired
    private SimpleSettlement ss;
    
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	GroupRepository groupRepository;
    
	/*
	 * Do not respect the single test guidelines but fuck JEE that shit ain't working 
	 */
    @Test
    public void testSettlement() {
    	int size = 1000;
    	//test settlement
    	personRepository.deleteAll();
    	groupRepository.deleteAll();
    	ss.settle(size, size);
    	assertEquals(size, personRepository.count());
    	assertEquals(size, groupRepository.count());
    	
    	//test association
    	//ss.associate();
    	//groupRepository.saveAll(ss.getGroups());
    	//assertEquals(size, personRepository.count());
    	//assertEquals(size, groupRepository.count());
    	for(Group g : groupRepository.findAll()) {
    		long id = g.getId();
    		int length = groupRepository.getById(id).getPersonsLazy().size();
    		assertEquals(g.getPersons().size(), length);
    	}
    }
}