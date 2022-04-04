package mybootapp.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.model.Group;
import mybootapp.model.Person;

public class DirectoryManager implements IDirectoryManager {
	@Autowired
	IEntityDao Dao;
	
    @Autowired
    private PersonRepository personDao;
    @Autowired
    private GroupRepository groupDao;

	@Override
	public User newUser() {
		return new User();
		
	}

	@Override
	public Optional<Person> findPerson(User user, long personId) {
		return personDao.findById(personId);
	}

	@Override
	public Optional<Group> findGroup(User user, long groupId) {
		return groupDao.findById(groupId);
	}

	@Override
	public boolean login(User user, String mailAddress, String password) {
		Person p = personDao.login(mailAddress, password);
		if(p == null) return false;
		user = new User(p.getFirstName(), 
				p.getLastName(), 
				p.getMailAddress(), 
				p.getWebAddress(), p.getBirthDay());
		return true;
	}

	@Override
	public void logout(User user) {
		user = newUser();
	}

	@Override
	public void savePerson(User user, Person p) {
		// TODO Auto-generated method stub
		personDao.save(p);
	}

	@Override
	public void saveGroup(User user, Group g) {
		groupDao.save(g);
	}


}
