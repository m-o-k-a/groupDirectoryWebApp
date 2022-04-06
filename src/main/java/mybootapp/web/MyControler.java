package mybootapp.web;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		index.addObject("peopleAmount", dm.getAmountOfPerson(user));
		index.addObject("groupAmount", dm.getAmountOfGroup(user));
		return index;
	}
	
    @PostConstruct
    @Transactional
    public void init() {
    	settlement.settle(1000, 1000);
    }

}
