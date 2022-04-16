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
import org.junit.jupiter.api.Disabled;
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
	DirectoryManager dm;
	
    @Test
    //@Disabled("Able test will purge the database")
    public void testSettlement() {
    	int size = 1000;
    	//test settlement
    	dm.deleteAll();
    	
    	ss.settle(size, size);
    	assertEquals(size, dm.getAmountOfPerson(null));
    	assertEquals(size, dm.getAmountOfGroup(null));
    	
    	for(Group g :dm.findAllGroup(null)) {
    		long id = g.getId();
    		Optional<Group> opt_g = dm.findGroup(null, g.getId());
    		int length = opt_g.get().getPersonsLazy().size();
    		assertEquals(g.getPersons().size(), length);
    	}
    }
}