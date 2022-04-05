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
    public ModelAndView listGroups() {
        logger.info(user+" : Requested List of Group");
        Collection<Group> groups = dm.findAllGroup(user);
        ModelAndView res = new ModelAndView("groupsList", "groups", groups);
        res.addObject("cat", "groups");
        return res;
    }

}
