package mybootapp.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    //@Column(name = "first_name", length = 200, nullable = false, unique = false)
    private String firstName;
    
    @Basic
    //@Column(name = "last_name", length = 200, nullable = false, unique = false)
    private String lastName;
    
    @Basic
    //@Column(name = "mail_address", length = 200, nullable = false, unique = true)
    private String mailAddress;
    
    @Basic
    //@Column(name = "web_address", length = 200, nullable = true, unique = true)
    private String webAddress;

    @Basic
    @Temporal(TemporalType.DATE)
    //@Column(name = "birth_day")
    private Date birthDay;
    
    //TODO update if possible password field
    @Basic
    //@Column(name = "password", length = 400, nullable = false, unique = false)
    private String password;
    
    public Person(String firstName, String lastName, String mailAddress, String webAddress, Date birthDay, String password) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.mailAddress = mailAddress;
    	this.webAddress = webAddress;
    	this.birthDay = birthDay;
    	this.password = password;
    }
}