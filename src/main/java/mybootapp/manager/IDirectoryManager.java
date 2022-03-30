package mybootapp.manager;

import java.util.Optional;

import mybootapp.model.Groups;
import mybootapp.model.Person;

public interface IDirectoryManager {
	
	//Create an anonymous user
	User newUser();
	
	Optional<Person> findPerson(User user, long personId);
	
	Optional<Groups> findGroup(User user, long groupId);
	
	boolean login(User user, String mailAddress, String password);
	
	void logout(User user);
	
	void savePerson(User user, Person p);
	
	void saveGroup(User user, Groups g);
	

}
