package mybootapp.manager;
import java.util.Collection;
import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@Transactional
@Repository
public class EntityDao implements IEntityDao {
	
	
	@Autowired
    @PersistenceContext(unitName = "dataname")
    EntityManager em;
	
	@Override
	public Collection<Group> findAllGroups() {
		String query = "SELECT g FROM Group g ORDER BY name ";
		TypedQuery<Group> q = em.createQuery(query, Group.class);
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public Collection<Group> findGroupsByName(String name) {
		String query = "SELECT g FROM Group g WHERE g.name LIKE :name Order by ";
		
		TypedQuery<Group> q = em.createQuery(query, Group.class);
		
		q.setParameter("name", "%"+name+"%");
		try {
			return q.getResultList();
			
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
