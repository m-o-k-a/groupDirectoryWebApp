package mybootapp.service;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.model.Group;
import mybootapp.model.Person;

@Service("simpleSettlement")
public class SimpleSettlement implements ISettlement {
	
	private Random rand = new Random();

	@Autowired
	public GroupRepository gr;
	
	@Autowired
	public PersonRepository pr;
	
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
			pr.saveAndFlush(p);
		}
		
		for(int i = 0; i<amountOfGroup; i++) {
			Group g = new Group("Group-"+i);
			gr.saveAndFlush(g);
		}
		associate();
	}
	
	public void associate() {
		for(Group g : gr.findAll()) {
			for(Person p : pr.findAll()) {
				Optional<Group> go = gr.findById(g.getId());
				if(go.isPresent()) {}//System.out.println("- OUI UN GROUP EXISTE BIEN DANS LA BASE AVEC ID "+go.get().getId());
				if(rand.nextInt(10)%3 == 0) {
					g.getPersonsLazy();
					g.addPerson(p);
				}
			}
			gr.saveAndFlush(g);
		}
	}
}

/* previous

	private Random rand = new Random();
	private Collection<Person> persons = new HashSet<Person>();
	private Collection<Group> groups = new HashSet<Group>();
	
	//public GroupRepository getGroupRepository() { return groupRepository; }
	
	//public PersonRepository getPersonRepository() { return personRepository; }
	
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
			//personRepository.save(p);
			persons.add(p);
		}
		
		for(int i = 0; i<amountOfGroup; i++) {
			Group g = new Group("Group-"+i);
			//groupRepository.save(g);
			groups.add(g);
		}
	}
	
	public void associate() {
		for(Group g : groups) {
			g.getPersons().clear();
			for(Person p : persons) {
				//if(rand.nextInt(10)%3 == 0) {
					System.out.println(">> AJOUT DE LA PERSONNE ID "+p.getIdSafe()+" DANS LE GROUPE ID "+g.getIdSafe());
					g.addPerson(p);
				//}
			}
		}
	}

	@Override
	public Collection<Person> getPersons() {
		return persons;
	}
	
	@Override
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

	@Override
	public Collection<Group> getGroups() {
		return groups;	
	}

	@Override
	public void reset() {
		persons = new HashSet<Person>();
		groups = new HashSet<Group>();
	}

	@Override
	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}
	
	

*/