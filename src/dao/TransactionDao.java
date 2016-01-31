package dao;

import java.util.List;

import model.Transaction;

public interface TransactionDao {

	public void add(Transaction transaction);
	public void delete(Integer id);
	public Transaction getById(Integer id);
	public void update(Transaction transaction);
	public List<Transaction> getAll();
	public List<Transaction> getAllByIdCompte(Integer idcompte);
}
