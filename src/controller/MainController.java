package controller;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.CompteDao;
import dao.TransactionDao;
import dao.UserDao;

@Controller
public class MainController {

	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompteDao compteDao;
	
	@RequestMapping({"/admin","/admin/index"})
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/admin/index");
		modelView.addObject("transactions", transactionDao.getAll());
		return modelView;
	}
	
	@RequestMapping({"/user","/user/clients"})
	public ModelAndView user() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userDao.getByUsername(auth.getName());
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/user/index");
		modelView.addObject("solde", user.getComptes().iterator().next().getSolde());
		modelView.addObject("transactions", transactionDao.getAllByIdCompte(1));
		
		
		return modelView;
	}
	
	
	@RequestMapping(value="/index")
	public ModelAndView accueil(@RequestParam(value="erreur",required=false)String erreur,
			@RequestParam(value="logout",required=false)String logout){		
		ModelAndView modelview=new ModelAndView();
		
		if(erreur!=null)
			modelview.addObject("msg_erreur","Mot de passe ou Nom d'utilisateur invalide !");
		
		if(logout!=null)
			modelview.addObject("msg_logout","Déconnection avec succès !");

		
		modelview.setViewName("index");
		return modelview;	
	}
	
	@RequestMapping("/admin/clients")
	public ModelAndView clients() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/admin/clients");
		modelView.addObject("comptes", compteDao.getAll());
		
		return modelView;
	}

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}
	
	
}
