package mybootapp.manager;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.model.Group;
import mybootapp.model.Person;

public class DirectoryManager implements IDirectoryManager {
	
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GroupRepository groupRepository;
    
	@Override
	public User newUser() {
		return new User();
	}
	
	@Override
	public Optional<Person> findPerson(User user, long id) {
		return personRepository.findById(id);
	}
	
	@Override
	public Collection<Person> findAllPerson(User user) {
		return personRepository.findAll();
	}
	
	@Override
	public Collection<Person> findPersonByName(User user, String firstName, String lastName) {
		if(firstName.length() > 0) {
			if(lastName.length() > 0) { return personRepository.findByFirstNameLikeAndLastNameLike(firstName, lastName); } 
			return personRepository.findByFirstNameLike(firstName);
		}
		return personRepository.findByLastNameLike(lastName);
	}
	
	@Override
	public boolean savePerson(User user, Person p) {
		Person res = personRepository.save(p);
		return (res != null);
	}
	
	@Override
	public void removePerson(User user, Person p) {
		personRepository.delete(p);
	}
	
	@Override
	public Optional<Group> findGroup(User user, long id) {
		return groupRepository.findById(id);
	}
	
	@Override
	public Collection<Group> findAllGroup(User user) {
		return groupRepository.findAll();
	}
	
	@Override
	public Collection<Group> findGroupByName(User user, String name) {
		return groupRepository.findByNameLike(name);
	}
	
	@Override
	public boolean saveGroup(User user, Group g) {
		Group res = groupRepository.save(g);
		return (res != null);
	}
	
	@Override
	public void removeGroup(User user, Group g) {
		groupRepository.delete(g);
	}
	
	@Override
	public boolean login(User user, String mailAddress, String password) {
		Person p = personRepository.login(mailAddress, password);
		if(p == null) return false;
		user = new User(p.getId(),
				p.getFirstName(), 
				p.getLastName(), 
				p.getMailAddress(), 
				p.getWebAddress(), 
				p.getBirthDay());
		return true;
	}

	@Override
	public boolean logout(User user) {
		user = newUser();
		return (user != null);
	}

}
