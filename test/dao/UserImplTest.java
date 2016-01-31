package dao;

import static org.junit.Assert.*;
import model.User;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserImplTest {
	
	ClassPathXmlApplicationContext context;
	UserDao userDao;
	String username = "abdelaziz_houmadi";
	User user;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) context.getBean("user");
		user=userDao.getByUsername("abdelaziz_houmadi");
	}
	
	@Ignore
	@Test
	public void testGetByUsername() {
		assertEquals(username, user.getUsername());
	}
	
	@Ignore
	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	

}
