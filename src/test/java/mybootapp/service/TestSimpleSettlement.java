package mybootapp.service;

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

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.web.Starter;
import mybootapp.model.Groups;
import mybootapp.model.Person;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)

public class TestSimpleSettlement {

    @Autowired
    private GroupRepository groupRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private SimpleSettlement ss;
    
    @Test
    public void testSettlement() {
    	ss.settle(100, 100);
    	assertEquals(100, groupRepository.count());
    	assertEquals(100, personRepository.count());
    }
}