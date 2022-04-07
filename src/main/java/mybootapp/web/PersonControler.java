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
import mybootapp.service.ErrorService;
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
	IDirectoryManager dm;
	
	@Autowired
	ErrorService errorService;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPersons(Model model, HttpSession httpSession, @RequestParam(value="firstName") Optional<String> qFirstName, @RequestParam(value="lastName") Optional<String> qLastName) {
        logger.info((User) httpSession.getAttribute("user")+" : Requested List of People");
        String fn = (qFirstName.isEmpty()) ? "" : qFirstName.get();
        String ln = (qLastName.isEmpty()) ? "" : qLastName.get();
        Collection<Person> persons = dm.findPersonByName((User) httpSession.getAttribute("user"), fn, ln);
        ModelAndView res = new ModelAndView("personsList", "persons", persons);
        res.addObject("cat", "persons");
        res.addObject("user", (User) httpSession.getAttribute("user"));
        model.addAttribute("person", new Person());
        errorService.manage(res, httpSession);
        return res;
    }
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ModelAndView showPerson(Model model, @PathVariable("id") Long id, HttpSession httpSession) {
        logger.info((User) httpSession.getAttribute("user")+" : Requested Show Person of id : "+id);
        Optional<Person> person = dm.findPerson((User) httpSession.getAttribute("user"), id);      
        if(person.isEmpty()) {
        	//todo manage
        }
        Person pr = person.get();
        ModelAndView res = new ModelAndView("personShow", "pr", pr);
        res.addObject("user", (User) httpSession.getAttribute("user"));
        res.addObject("cat", "persons");
        model.addAttribute("person", new Person());
        errorService.manage(res, httpSession);
        return res;
    }

}
