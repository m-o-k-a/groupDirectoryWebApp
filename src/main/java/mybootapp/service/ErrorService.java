package mybootapp.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Service("error")
public class ErrorService {
	
	public void manage(ModelAndView model, HttpSession httpSession) {
		signInError(model, httpSession);
		updateMailAddressError(model, httpSession);
	}

	private void signInError(ModelAndView model, HttpSession httpSession) {
		if(httpSession.getAttribute("errorSignIn") != null && ((boolean) httpSession.getAttribute("errorSignIn")) == true) {
			 model.addObject("errorSignIn", true);
			 httpSession.setAttribute("errorSignIn", false);
		}
	}
	
	private void updateMailAddressError(ModelAndView model, HttpSession httpSession) {
		if(httpSession.getAttribute("errorUpdateMailAddress") != null && ((boolean) httpSession.getAttribute("errorUpdateMailAddress")) == true) {
			 model.addObject("errorUpdateMailAddress", true);
			 httpSession.setAttribute("errorUpdateMailAddress", false);
		}
	}

}
