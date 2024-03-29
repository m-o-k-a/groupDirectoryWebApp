package mybootapp.service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.web.User;
import mybootapp.SpringConfiguration;
import mybootapp.model.Group;
import mybootapp.model.Person;

@Service("directoryManager")
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
		if(lastName.length() > 0) {
			return personRepository.findByLastNameLike(lastName);
		}
		return personRepository.findAll();
	}
	
	@Override
	public Collection<Person> findPersonByMailAddress(User user, String mailAddress) {
		return personRepository.findByMailAddress(mailAddress);
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
	public Collection<Person> login(User user, String mailAddress, String password) {
		return personRepository.login(mailAddress, password);
	}

	@Override
	public boolean logout(User user) {
		user = newUser();
		return (user != null);
	}

	@Override
	public void saveAllPerson(User user, Collection<Person> p) {
		personRepository.saveAll(p);
	}

	@Override
	public void saveAllGroup(User user, Collection<Group> g) {
		groupRepository.saveAll(g);
	}

	@Override
	public Long getAmountOfPerson(User user) {
		return personRepository.count();
	}

	@Override
	public Long getAmountOfGroup(User user) {
		return groupRepository.count();
	}

	@Override
	public void reset() {
		groupRepository.deleteAll();
		personRepository.deleteAll();
	}

	@Override
	public void flush() {
		personRepository.flush();
		groupRepository.flush();
	}

	@Override
	public void deleteAll() {
		groupRepository.deleteAll();
		personRepository.deleteAll();
		flush();
	}

}
