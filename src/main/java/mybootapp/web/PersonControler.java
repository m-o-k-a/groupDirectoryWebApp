package mybootapp.web;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView listPersons(Model model, @RequestParam(value="firstName") Optional<String> qFirstName, @RequestParam(value="lastName") Optional<String> qLastName) {
        logger.info(user+" : Requested List of People");
        String fn = (qFirstName.isEmpty()) ? "" : qFirstName.get();
        String ln = (qLastName.isEmpty()) ? "" : qLastName.get();
        Collection<Person> persons = dm.findPersonByName(user, fn, ln);
        ModelAndView res = new ModelAndView("personsList", "persons", persons);
        res.addObject("cat", "persons");
        model.addAttribute("person", new Person());
        return res;
    }
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ModelAndView showPerson(Model model, @PathVariable("id") Long id) {
        logger.info(user+" : Requested Show Person of id : "+id);
        Optional<Person> person = dm.findPerson(user, id);      
        if(person.isEmpty()) {
        	//todo manage
        }
        Person pr = person.get();
        ModelAndView res = new ModelAndView("personShow", "pr", pr);
        res.addObject("user", user);
        res.addObject("cat", "persons");
        model.addAttribute("person", new Person());
        return res;
    }

}
