package mybootapp.web;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.service.IDirectoryManager;
import mybootapp.service.ISettlement;

@Controller
@RequestMapping("/")
public class MyControler {
	
	@Autowired
	User user;
	
	@Autowired
	IDirectoryManager directoryManager;
	
	@Autowired
	ISettlement settlement;
	
	/*
	 * Point d'entrée principal de l'application.
	 */
	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
    @PostConstruct
    public void init() {
    	//todo fix issue to give
		try {
	    	settlement.settle(20, 10);
	    	directoryManager.saveAllPerson(user, settlement.getPersons());
	    	directoryManager.saveAllGroup(user, settlement.getGroups());
	    	settlement.associate();
	    	directoryManager.saveAllGroup(user, settlement.getGroups());
		} catch(Exception e) {}
    }

}
