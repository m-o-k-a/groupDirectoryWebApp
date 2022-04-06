package mybootapp.web;

import java.util.ArrayList;
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
@RequestMapping("/groups")
public class GroupControler {
	//Attributes
	protected final Log logger = LogFactory.getLog(getClass());
	  
	@Autowired
	User user;
	  
	@Autowired
	IDirectoryManager dm;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listGroups(Model model, @RequestParam(value="name") Optional<String> qName) {
        logger.info(user+" : Requested List of Group");
        Collection<Group> groups;
        if(!qName.isEmpty()) groups = dm.findGroupByName(user, qName.get());
        else groups = dm.findAllGroup(user);
        ModelAndView res = new ModelAndView("groupsList", "groups", groups);
        res.addObject("cat", "groups");
        model.addAttribute("group", new Group());
        return res;
    }
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ModelAndView showGroup(@PathVariable("id") Long id) {
        logger.info(user+" : Requested Show Group of id : "+id);
        Optional<Group> group = dm.findGroup(user, id);      
        if(group.isEmpty()) {
        	//todo manage
        }
        Group gr = group.get();
        Collection<Person> persons = gr.getPersons();
        ModelAndView res = new ModelAndView("groupShow", "gr", gr);
        res.addObject("persons", persons);
        res.addObject("user", user);
        res.addObject("cat", "groups");
        return res;
    }
    
    

}
