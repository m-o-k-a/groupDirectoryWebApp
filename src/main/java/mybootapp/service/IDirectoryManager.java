package mybootapp.service;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.web.User;

import java.util.Optional;


import java.util.Collection;
public interface IDirectoryManager {
	
	User newUser();
	void reset();
	
	Optional<Person> findPerson(User user, long id);
	Collection<Person> findAllPerson(User user);
	Collection<Person> findPersonByName(User user, String firstName, String lastName);
	Collection<Person> findPersonByMailAddress(User user, String mailAddress);
	boolean savePerson(User user, Person p);
	void saveAllPerson(User user, Collection<Person> p);
	void removePerson(User user, Person p);
	Long getAmountOfPerson(User user);
	
	Optional<Group> findGroup(User user, long id);
	Collection<Group> findAllGroup(User user);
	Collection<Group> findGroupByName(User user, String name);
	boolean saveGroup(User user, Group g);
	void saveAllGroup(User user, Collection<Group> g);
	void removeGroup(User user, Group g);
	Long getAmountOfGroup(User user);
	
	Collection<Person> login(User user, String mailAddress, String password);	
	boolean logout(User user);
	void flush();
}
