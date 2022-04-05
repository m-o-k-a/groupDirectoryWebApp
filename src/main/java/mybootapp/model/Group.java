package mybootapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Table(name = "group_table")
public class Group implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    //@Column(name = "name", length = 200, nullable = false, unique = false)
    private String name;
    
    @ManyToMany( fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.ALL }
  	      )
  	   @JoinTable(
  	      name = "Person_Group",
  	      joinColumns = { @JoinColumn(name = "id_person") },
  	      inverseJoinColumns = { @JoinColumn(name = "id_group") }
  	      )
  	   @ToString.Exclude
  	   Set<Person> persons;
    
	   public void addPerson(Person person) {
 	      if (persons == null) persons = new HashSet<>();
 	      persons.size();
 	      persons.add(person);
 	   }
	   public void removePerson(Person person) {
  	      if (person == null) return;
  	      persons.size();
  	      persons.remove(person);
  	   }
	   public Set<Person> getPersonsLazy() {
	 	      if (persons == null) persons = new HashSet<>();
	 	      persons.size();
	 	      return persons;
	 	   }

    public Group(String name) {
        this.name = name;
        this.persons = new HashSet<>();
    }

}