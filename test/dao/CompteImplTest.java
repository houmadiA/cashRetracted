package dao;

import static org.junit.Assert.*;
import model.Compte;
import model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(MockitoJUnitRunner.class) 
public class CompteImplTest {
	
	@Mock
	UserDao userMock;
	ClassPathXmlApplicationContext context;
	CompteDao compteDao;
	
	Compte cpt;
	User user = new User("mohamed_outegda", "123", true, "ROLE_USER");

	@Before
	public void init(){
		//when(userMock.getByUsername("mohamed_outegda")).thenReturn(user);
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		compteDao = (CompteDao) context.getBean("compte");
	}
	
	@Test
	public void testAdd() {
		cpt = new Compte(user);
		compteDao.add(cpt);
	}

}
