package mybootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mybootapp.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
    //Person findById(long id);

    List<Person> findByFirstName(String name);

    List<Person> findByFirstNameLike(String name);
    
    List<Person> findByLastName(String name);
    
    List<Person> findByLastNameLike(String name);
    
    @Modifying
    @Query("delete from Person p where p.firstName like ?1")
    void deleteLikeFirstName(String pattern);
    
    @Modifying
    @Query("delete from Person p where p.lastName like ?1")
    void deleteLikeLastName(String pattern);
    
    @Modifying
    @Query("select p from Person p where p.mailAddress like ?1 and p.password like ?2")
    Person login(String mailAddress, String password);

}