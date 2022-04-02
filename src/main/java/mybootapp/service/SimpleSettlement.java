package mybootapp.service;

import java.util.Optional;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.model.Groups;
import mybootapp.model.Person;

@Service("simpleSettlement")
@Transactional
public class SimpleSettlement implements ISettlement {
	
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	GroupRepository groupRepository;
	
	private Random rand = new Random();
	
	@Override
	public void settle(int amountOfPerson, int amountOfGroup) {
		for(int i = 0; i<amountOfPerson; i++) {
			Date date = new Date();
			Person p = new Person("FirstName"+i, 
					"LastName"+i, 
					i+"@settlement.com", 
					i+"-settlement.com",
					date, 
					"password"+i);
			personRepository.save(p);
		}
		
		for(int i = 0; i<amountOfGroup; i++) {
			Groups g = new Groups("Group-"+i);
			groupRepository.save(g);
			for(int j = 0; j<amountOfPerson; j++) {
				if(rand.nextInt(10)%3 == 0) {
					Optional<Person> person = personRepository.findById((long) i);
					if(person.isEmpty() || person.get() == null || person.get().getFirstName().isEmpty()) continue;
					//todo dirty but try to find a better way to avoid NaN or nullable values
					try {
						g.addPerson(person.get());
						groupRepository.save(g);
					} catch(Exception e) {}
				}
			}
		}
	}
	
	

}
