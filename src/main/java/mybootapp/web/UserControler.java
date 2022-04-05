package mybootapp.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mybootapp.service.IDirectoryManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
@RequestMapping("/User")
public class UserControler {
	
	protected final Log logger = LogFactory.getLog(getClass());
	  
	@Autowired()
	User user;
	  
	@Autowired
	@Qualifier("directoryManagerBean")
	IDirectoryManager directoryManagerBean;

	@ModelAttribute("user")
	public User newUser() {
		return user;
	}
  
    @RequestMapping(value = "/logout")
    public String logout() {
        logger.info("logout  " + user);
        //manager.logout(user);
        return "/";
    }
    
	@RequestMapping(value = "/login")
	public String login(
			@RequestParam(value = "id", required = true) String Id,
	    	@RequestParam(value = "passwd", required = true) String password,
	    	final RedirectAttributes redirAttributes) {
	        
	        /*if (manager.login(user, Id, password)) {
	        	logger.info("login here " + user);
	        	return "home";
	        }*/
	        
	        redirAttributes.addFlashAttribute("Connection error", true);
	        logger.info("Failed login attempt");
	        return "login";
	    }
	  
	  
	  
	  
	  
	  
	  

}
