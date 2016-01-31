package metier;

import model.Compte;
import model.Transaction;
import model.TransactionIn;
import model.User;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.CompteDao;
import dao.UserDao;

@Service("transactionProcessor")
public class TransactionProcessor implements
		ItemProcessor<TransactionIn, Transaction> {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompteDao compteDao;
	
	public Transaction process(final TransactionIn transactionInput)
			throws Exception {
		
		Transaction transactionOutput = new Transaction();
		transactionOutput.setIdtransaction(transactionInput.getIdtransaction());
		transactionOutput.setCompte(compteDao.getById(transactionInput.getIdCompte()));
		transactionOutput.setMontant(transactionInput.getMontant());
		transactionOutput.setDate(transactionInput.getDate());
		
		Compte compte = transactionOutput.getCompte();
		compte.setSolde(compte.getSolde()+transactionOutput.getMontant());
		compteDao.update(compte);
		
		return transactionOutput;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}

}
