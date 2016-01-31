package dao;

import java.util.List;

import model.Compte;

public interface CompteDao {
	
	public void add(Compte compte);
	public void delete(Integer id);
	public Compte getById(Integer id);
	public void update(Compte compte);
	public List<Compte> getAll();

}
