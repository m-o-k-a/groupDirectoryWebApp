package mybootapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import mybootapp.model.Groups;
import mybootapp.model.Person;

@Service("settlement")
public interface ISettlement {
	
	void settle(int amountOfPerson, int amountOfGroup);
	
	List<Person> getPersons();
	
	List<Groups> getGroups();
}
