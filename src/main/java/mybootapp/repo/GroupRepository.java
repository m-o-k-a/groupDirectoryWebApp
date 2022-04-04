package mybootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mybootapp.model.Group;
import mybootapp.model.Person;

public interface GroupRepository extends JpaRepository<Group, Long> {
	
	//Group findById(long id);

    List<Group> findByName(String name);

    List<Group> findByNameLike(String name);
    
    @Modifying
    @Query("delete from Groups g where g.name like ?1")
    void deleteLikeName(String pattern);

}