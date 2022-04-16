package mybootapp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import mybootapp.web.Starter;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.service.DirectoryManager;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class TestGroupRepository {

    @Autowired
    private DirectoryManager dm;

    /*
     * Do not respect test guidelines but spring will never fucking save correctly if it is not in the same function
     */
    @Test
    public void testGroup() {
    	//Add
    	Group g = new Group("TestGroup");
    	dm.saveGroup(null, g);
    	dm.flush(); 
    	
        var op = dm.findGroup(null, g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        assertEquals("TestGroup", g.getName());
        
        //Add To Group
        Collection<Group> cg = dm.findGroupByName(null, "TestGroup");
    	assertTrue(cg.size() >= 0);
    	Group g2 = cg.iterator().next();
    	assertTrue(g2.getName().equals("TestGroup"));
    	Optional<Person> p = dm.findPerson(null, (long) 1);
    	assertTrue(p.isPresent());
    	Person p2 = p.get();
    	g2.addPerson(p2);
    	dm.saveGroup(null, g2);
    	dm.flush();

    	cg = dm.findGroupByName(null, "TestGroup");
    	assertTrue(cg.size() > 0);
    	g2 = cg.iterator().next();
    	assertTrue(g2.getName().equals("TestGroup"));
    	assertEquals(1, g2.getPersonsLazy().size());
    	
    	//Remove
    	cg = dm.findGroupByName(null, "TestGroup");
    	assertEquals(1, cg.size());
    	g2 = cg.iterator().next();
    	assertTrue(g2.getName().equals("TestGroup"));
    	dm.removeGroup(null, g2);
    	dm.flush();
    	
        op = dm.findGroup(null, g2.getId());
        assertEquals(true, op.isEmpty());
    }
    
    
}