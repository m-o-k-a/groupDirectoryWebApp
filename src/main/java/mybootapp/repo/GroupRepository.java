package mybootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mybootapp.model.Group;
import mybootapp.model.Person;

public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByNameLike(String name);
    
    @Modifying
    @Query("delete from Group g where g.id like ?1")
    void deleteById(Long id);

}