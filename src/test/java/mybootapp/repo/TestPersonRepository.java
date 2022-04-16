package mybootapp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import mybootapp.web.Starter;
import mybootapp.model.Person;
import mybootapp.service.DirectoryManager;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class TestPersonRepository {

    @Autowired
    private DirectoryManager dm;
    
    private String[] values = {"John", "Doe", "john@doe", "john.doe", "password"};
    private Date date = new Date();
    private Person p = new Person(values[0], values[1], values[2], values[3], date, values[4]);
    
    @Test
    /*
     * Do not respect test guidelines but spring will never fucking save correctly if it is not in the same function
     */
    public void testPerson() {
    	//Add
    	dm.savePerson(null, p);
        Collection<Person> op = dm.findPersonByName(null, values[0], values[1]);
        assertEquals(1, op.size());
        p = op.iterator().next();
        assertEquals(values[0], p.getFirstName());
        assertEquals(values[1], p.getLastName());
        assertEquals(values[2], p.getMailAddress());
        assertEquals(values[3], p.getWebAddress());
        
        //Remove
        op = dm.findPersonByName(null, values[0], values[1]);
        assertEquals(1, op.size());
        p = op.iterator().next();
        dm.removePerson(null, p);
        assertTrue(dm.findPerson(null, p.getId()).isEmpty());
    }
}