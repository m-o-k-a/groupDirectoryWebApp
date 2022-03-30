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
	
	@PostConstruct
	public void start() {
		settle(100, 100);
	}
	
	@Override
	public void settle(int amountOfPerson, int amountOfGroup) {
		//Groups Creations
		for(int i = 0; i<amountOfGroup; i++) {
			Groups group = new Groups("Group-"+i);
			groupRepository.save(group);
		}
		for(int i = 0; i<amountOfPerson; i++) {
			Date date = new Date();
			Person p = new Person("FirstName"+i, 
					"LastName"+i, 
					i+"@settlement.com", 
					i+"-settlement.com",
					date, 
					"password"+i);
			//personRepository.save(p);
			//todo check this
			//probably call to non existing ressources due to the optionnal
			for(int j = 0; j<amountOfGroup; j++) {
				if(rand.nextInt(10)%3 == 0) {
					Optional<Groups> group = groupRepository.findById((long) i);
					if(group.isEmpty() || group.get() == null || group.get().getName().isEmpty()) continue;
					//todo dirty but try to find a better way to avoid NaN or nullable values
					try {
						p.addGroup(group.get());
						personRepository.save(p);
					} catch(Exception e) {}
				}
			}
		}
	}

}
