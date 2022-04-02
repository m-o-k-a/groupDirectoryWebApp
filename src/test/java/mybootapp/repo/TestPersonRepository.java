package mybootapp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
@ContextConfiguration(classes = Starter.class)
public class TestPersonRepository {

    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private GroupRepository groupRepository;
    
    private String[] values = {"John", "Doe", "john@doe", "john.doe", "password"};
    private Date date;
    private Person p;
    private Groups g;
    
    @BeforeEach
    public void initEach() {
    	date = new Date();
        p = new Person(values[0], values[1], values[2], values[3], date, values[4]);
        personRepository.deleteAll();
        assertFalse(personRepository.findAll().iterator().hasNext());
        g = new Groups("onlyGroup");
        groupRepository.deleteAll();
        assertFalse(groupRepository.findAll().iterator().hasNext());
    }

    @Test
    public void testAddPerson() {
        personRepository.save(p);
        var op = personRepository.findById(p.getId());
        assertTrue(op.isPresent());
        p = op.get();
        assertEquals(values[0], p.getFirstName());
        assertEquals(values[1], p.getLastName());
        assertEquals(values[2], p.getMailAddress());
        assertEquals(values[3], p.getWebAddress());
    }
    
    @Test
    public void testRemovePerson() {
        personRepository.save(p);
        var op = personRepository.findById(p.getId());
        assertTrue(op.isPresent());
        p = op.get();
        personRepository.delete(p);
        op = personRepository.findById(p.getId());
        assertEquals(Optional.empty(), op);
    }
}