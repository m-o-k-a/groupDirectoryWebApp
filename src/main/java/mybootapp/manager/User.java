package mybootapp.manager;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String firstName;
	private String lastName;
	private String mailAddress;
	private String webAddress;
	private Date birthDay;
	
}
