package mybootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mybootapp.model.Groups;
import mybootapp.model.Person;

public interface GroupRepository extends JpaRepository<Groups, Long> {
	
	//Group findById(long id);

    List<Groups> findByName(String name);

    List<Groups> findByNameLike(String name);
    
    @Modifying
    @Query("delete from Groups g where g.name like ?1")
    void deleteLikeName(String pattern);

}