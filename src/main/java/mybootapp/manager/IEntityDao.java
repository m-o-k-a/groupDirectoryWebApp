package mybootapp.manager;

import java.util.Collection;

	
import mybootapp.model.Group;
import mybootapp.model.Person;
	
	
	

public interface IEntityDao {
	
	
	void updatePerson(Person person);
	void removePerson (long id );
	void addPerson(Person person);
	Person findPerson(Long id);
	Collection<Person>findAllPersons();
	Collection<Person>findAllPersonsByGroup(Long groupeId );
	Collection<Person> findPersonbyName(String name);
	
	
	
	void addGroup(Group groups);
	void removeGroup (long id );
	Group findGroup(long id);
	Collection<Group> findGroupsbyName(String name);
	
	
	
	
	
	
	

}
