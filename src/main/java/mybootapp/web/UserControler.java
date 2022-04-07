package mybootapp.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    	if(((User) httpSession.getAttribute("user")) == null) {
        	String mailAddress = qp.getMailAddress();
        	String password = qp.getPassword();
        	Collection<Person> cp = dm.login((User) httpSession.getAttribute("user"), mailAddress, password);
    		if(cp != null && !cp.isEmpty()) {
        		Person p = cp.iterator().next();
        		User user = new User(p.getId(),
        				p.getFirstName(), 
        				p.getLastName(), 
        				p.getMailAddress(), 
        				p.getWebAddress(), 
        				p.getBirthDay());
        		httpSession.setAttribute("user", user);
    		}
    	}
    	return "redirect:"+ referer;	
    }

    @RequestMapping(value = "/signOut")
    public String logout(Model model, HttpSession httpSession) {
        //logger.info("logout  " + user);
    	if(((User) httpSession.getAttribute("user")) != null) {
            dm.logout((User) httpSession.getAttribute("user"));
            httpSession.setAttribute("user", new User());
    	}
        return "redirect:/";
    }

}
