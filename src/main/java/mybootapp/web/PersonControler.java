package mybootapp.web;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.service.IDirectoryManager;
import mybootapp.service.ISettlement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
@RequestMapping("/persons")
public class PersonControler {
	//Attributes
	protected final Log logger = LogFactory.getLog(getClass());
	  
	@Autowired
	User user;
	  
	@Autowired
	IDirectoryManager dm;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listGroups() {
        logger.info(user+" : Requested List of People");
        Collection<Person> persons = dm.findAllPerson(user);
        ModelAndView res = new ModelAndView("personsList", "persons", persons);
        res.addObject("cat", "persons");
        return res;
    }

}
