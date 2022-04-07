package mybootapp.web;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.service.IDirectoryManager;
import mybootapp.service.ISettlement;

@Controller
@RequestMapping("/")
public class MyControler {
	
	@Autowired
	User user;
	
	@Autowired
	IDirectoryManager dm;
	
	@Autowired
	ISettlement settlement;
	
	/*
	 * Point d'entrée principal de l'application.
	 */
	@RequestMapping("")
	public ModelAndView index(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("group", new Group());
		ModelAndView index = new ModelAndView("index");
		index.addObject("user", user);
		index.addObject("peopleAmount", dm.getAmountOfPerson(user));
		index.addObject("groupAmount", dm.getAmountOfGroup(user));
		return index;
	}
	
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Model model, @ModelAttribute Person qp, HttpServletRequest request) {
    	String mailAddress = qp.getMailAddress();
    	String password = qp.getPassword();
    	Collection<Person> cp = dm.login(user, mailAddress, password);
		if(cp == null || cp.isEmpty()) {
			//todo error
		}
		Person p = cp.iterator().next();
		user = new User(p.getId(),
				p.getFirstName(), 
				p.getLastName(), 
				p.getMailAddress(), 
				p.getWebAddress(), 
				p.getBirthDay());
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
	
    @PostConstruct
    @Transactional
    public void init() {
    	settlement.settle(1000, 1000);
    }

}
