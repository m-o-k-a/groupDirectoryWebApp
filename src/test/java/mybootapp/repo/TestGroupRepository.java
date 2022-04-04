package mybootapp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import mybootapp.repo.PersonRepository;
import mybootapp.web.Starter;
import mybootapp.model.Group;
import mybootapp.model.Person;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class TestGroupRepository {

    @Autowired
    private GroupRepository groupRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    private String[] values = {"Alpha"};
    private Date date;
    private Group g;
    
    @BeforeEach
    public void initEach() {
    	date = new Date();
        g = new Group(values[0]);
        groupRepository.deleteAll();
        assertFalse(groupRepository.findAll().iterator().hasNext());
    }

    @Test
    public void testAddGroup() {
        groupRepository.save(g);
        var op = groupRepository.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        assertEquals(values[0], g.getName());
    }
    
    @Test
    public void testRemoveGroup() {
        groupRepository.save(g);
        var op = groupRepository.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        groupRepository.delete(g);
        op = groupRepository.findById(g.getId());
        assertEquals(Optional.empty(), op);
    }
    
    @Test
    public void testAddToGroup() {
        groupRepository.save(g);
        var op = groupRepository.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        Person p = new Person("John", "Doe", "john@doe", "john.doe", date, "password");
        personRepository.save(p);
        g.addPerson(p);
        groupRepository.save(g);
        
        op = groupRepository.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        Set<Person> lst = g.getPersons();
        assertEquals(1, lst.size());
    }
    
}