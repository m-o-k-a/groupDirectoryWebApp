package mybootapp.web;
import org.springframework.beans.factory.annotation.Value;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.repo.PersonRepository;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mybootapp.manager.IDirectoryManager;

@Controller

public class PersonLogControler {
	
	@Autowired 
	User user; 
	//@Autowired 
	//IDirectoryManager manager;
	
	
	public User getUser() {
		return user ;
		
	}
	
	
	

}
