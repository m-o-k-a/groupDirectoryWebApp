package mybootapp.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mybootapp.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("select p from Person p where p.firstName like %?1%")
    Collection<Person> findByFirstNameLike(String firstName);
    
    @Modifying
    @Query("select p from Person p where p.lastName like %?1%")
    Collection<Person> findByLastNameLike(String lastName);
    
    @Modifying
    @Query("select p from Person p where p.firstName like ?1 and p.lastName like ?2")
    Collection<Person> findByFirstNameLikeAndLastNameLike(String firstName, String lastName);
    
    @Modifying
    @Query("delete from Person p where p.id like ?1")
    void deleteById(Long id);

    @Modifying
    @Query("select p from Person p where p.mailAddress like ?1 and p.password like ?2")
    Person login(String mailAddress, String password);

}