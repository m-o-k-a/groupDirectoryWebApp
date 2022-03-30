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
import mybootapp.model.Groups;
import mybootapp.model.Person;


@SpringBootTest
@ContextConfiguration(classes = Groups.class)
public class TestGroupRepository {

    @Autowired
    private GroupRepository groupDao;
    private PersonRepository personDao;
    
    private String[] values = {"Alpha"};
    private Date date;
    private Groups g;
    
    @BeforeEach
    public void initEach() {
    	date = new Date();
        g = new Groups(values[0]);
        groupDao.deleteAll();
        assertFalse(groupDao.findAll().iterator().hasNext());
    }

    @Test
    public void testAddGroup() {
        groupDao.save(g);
        var op = groupDao.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        assertEquals(values[0], g.getName());
    }
    
    @Test
    public void testRemoveGroup() {
        groupDao.save(g);
        var op = groupDao.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        groupDao.delete(g);
        op = groupDao.findById(g.getId());
        assertEquals(Optional.empty(), op);
    }
    
    @Test
    public void testAddToGroup() {
        groupDao.save(g);
        var op = groupDao.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        Person p = new Person("John", "Doe", "john@doe", "john.doe", date, "password");
        p.addGroup(g);
        personDao.save(p);
        //todo update the lazy thing in group/person table
        op = groupDao.findById(g.getId());
        assertTrue(op.isPresent());
        g = op.get();
        Set<Person> lst = g.getPersons();
        assertEquals(1, lst.size());
    }
    
}