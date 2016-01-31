import model.Compte;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CompteDao;


public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CompteDao cpt = (CompteDao) context.getBean("compte");
		Compte c = cpt.getById(1);
		System.err.println("solde de c avant "+c.getSolde());
		c.setSolde(c.getSolde()+1000);
		cpt.update(c);
		c=null;
		c = cpt.getById(1);
		System.err.println("solde de c apres "+c.getSolde());

	}

}
