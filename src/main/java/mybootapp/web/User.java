package mybootapp.web;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@SessionScope
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
	private String firstName;
	private String lastName;
	private String mailAddress;
	private String webAddress;
	private Date birthDay;
	
}


