package mybootapp.manager;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.manager.User;

import java.util.Optional;


import java.util.Collection;
public interface IDirectoryManager {
	
	//Create an anonymous user
	User newUser();
	
	Optional<Person> findPerson(User user, long personId);
	
	Optional<Group> findGroup(User user, long groupId);

    Collection<Person> findPersonsByName(User user, String name);
	
	Collection<Person>findAllpersons(User user);
	void savePerson(User user, Person p);
	Collection<Person>findAllpersonsByGroup(User user, Long groupeId);
	 Collection<Group> findAllGroup(User user);
	 Collection<Group> findGroupsByName(User user, String name);
	boolean login(User user, String mailAddress, String password);
	
	void logout(User user);
	

	void saveGroup(User user, Group g);
	

}
