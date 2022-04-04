package mybootapp.manager;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.manager.User;

import java.util.Optional;


import java.util.Collection;
public interface IDirectoryManager {
	
	//Create an anonymous user
	User newUser();
	
	Optional<Person> findPerson(User user, long id);
	Collection<Person>findAllPerson(User user);
	Collection<Person>findPersonByName(User user, String firstName, String lastName);
	boolean savePerson(User user, Person p);
	void removePerson(User user, Person p);
	
	Optional<Group> findGroup(User user, long id);
	Collection<Group> findAllGroup(User user);
	Collection<Group> findGroupByName(User user, String name);
	boolean saveGroup(User user, Group g);
	void removeGroup(User user, Group g);
	
	boolean login(User user, String mailAddress, String password);	
	boolean logout(User user);
}
