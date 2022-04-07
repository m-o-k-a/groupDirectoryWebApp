package mybootapp.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mybootapp.model.Person;
import mybootapp.service.IDirectoryManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
@RequestMapping("/user")
public class UserControler {
	
	protected final Log logger = LogFactory.getLog(getClass());
	  
	@Autowired
	IDirectoryManager dm;
    
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Model model, @ModelAttribute Person qp, HttpServletRequest request, HttpSession httpSession) {
        String referer = request.getHeader("Referer");
    	User user = ((User) httpSession.getAttribute("user"));
    	if(user == null || user.getId() == null) {
        	String mailAddress = qp.getMailAddress();
        	String password = qp.getPassword();
        	Collection<Person> cp = dm.login((User) httpSession.getAttribute("user"), mailAddress, password);
    		if(cp != null && !cp.isEmpty()) {
        		Person p = cp.iterator().next();
        		user = new User(p.getId(),
        				p.getFirstName(), 
        				p.getLastName(), 
        				p.getMailAddress(), 
        				p.getWebAddress(), 
        				p.getBirthDay());
        		httpSession.setAttribute("user", user);
    		} else { httpSession.setAttribute("errorSignIn", true); }
    	}
    	return "redirect:"+ referer;	
    }

    @RequestMapping(value = "/signOut")
    public String logout(Model model, HttpSession httpSession) {
        //logger.info("logout  " + user);
    	User user = ((User) httpSession.getAttribute("user"));
    	if(user != null && user.getId() != null) {
            dm.logout((User) httpSession.getAttribute("user"));
            httpSession.setAttribute("user", new User());
    	}
        return "redirect:/";
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView showPerson(Model model, HttpSession httpSession) {
    	model.addAttribute("person", new Person());
    	User user = ((User) httpSession.getAttribute("user"));
    	if(user == null || user.getId() == null) return new ModelAndView("redirect:/");
        logger.info((User) httpSession.getAttribute("user")+" : Requested Show of itself");
        ModelAndView res = new ModelAndView("userShow", "user", httpSession.getAttribute("user"));
        res.addObject("cat", "user");
        model.addAttribute("person", new Person());
        return res;
    }

}
