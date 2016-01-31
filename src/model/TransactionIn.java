package model;

public class TransactionIn {

	private Integer idtransaction;
	private Integer idCompte;
	private Integer montant;
	private String date;

	
	
	public TransactionIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionIn(Integer idtransaction, Integer idCompte,
			Integer montant, String date) {
		super();
		this.idtransaction = idtransaction;
		this.idCompte = idCompte;
		this.montant = montant;
		this.date = date;
	}

	public Integer getIdtransaction() {
		return idtransaction;
	}

	public void setIdtransaction(Integer idtransaction) {
		this.idtransaction = idtransaction;
	}

	public Integer getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
