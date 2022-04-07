package mybootapp.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Service("error")
public class ErrorService {
	
	public void manage(ModelAndView model, HttpSession httpSession) {
		signInError(model, httpSession);
	}

	private void signInError(ModelAndView model, HttpSession httpSession) {
		if(httpSession.getAttribute("errorSignIn") != null && ((boolean) httpSession.getAttribute("errorSignIn")) == true) {
			 model.addObject("errorSignIn", true);
			 httpSession.setAttribute("errorSignIn", false);
		}
	}

}
