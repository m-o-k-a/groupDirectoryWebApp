package mybootapp.web;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.service.IDirectoryManager;
import mybootapp.service.ISettlement;

@Controller
@RequestMapping("/")
public class MyControler {
	
	@Autowired
	IDirectoryManager dm;
	
	@Autowired
	ISettlement settlement;
	
	/*
	 * Point d'entrée principal de l'application.
	 */
	@RequestMapping("")
	public ModelAndView index(Model model, HttpSession httpSession) {
		model.addAttribute("person", new Person());
		model.addAttribute("group", new Group());
		ModelAndView index = new ModelAndView("index");
		index.addObject("peopleAmount", dm.getAmountOfPerson((User) httpSession.getAttribute("user")));
		index.addObject("groupAmount", dm.getAmountOfGroup((User) httpSession.getAttribute("user")));
		index.addObject("user", (User) httpSession.getAttribute("user"));
		return index;
	}
	
    @PostConstruct
    @Transactional
    public void init() {
    	settlement.settle(10, 10);
    }
}