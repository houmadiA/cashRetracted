package metier;

import java.util.List;

import model.Transaction;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TransactionDao;
import dao.UserDao;

@Service("tansactionWriter")
public class TransactionWriter implements ItemWriter<Transaction> {

	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private UserDao userDao;
	
	public void write(List<? extends Transaction> items) throws Exception {
		for (Transaction transaction : items) {
			transactionDao.add(transaction);
			System.err.println("transaction "+transaction.getDate()+" est fixée");
			
		}
	}

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
