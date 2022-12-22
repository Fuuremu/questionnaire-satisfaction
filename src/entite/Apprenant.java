package entite;

public class Apprenant {

	private int idApprenant;
	private String nomApprenant;
	private String emailApprenant; //adresse email
	
	public Apprenant(int idApprenant, String nomApprenant, String emailApprenant) {
		super();
		this.idApprenant = idApprenant;
		this.nomApprenant = nomApprenant;
		this.emailApprenant = emailApprenant;
	}

	public int getIdApprenant() {
		return idApprenant;
	}

	public void setIdApprenant(int idApprenant) {
		this.idApprenant = idApprenant;
	}

	public String getNomApprenant() {
		return nomApprenant;
	}

	public void setNomApprenant(String nomApprenant) {
		this.nomApprenant = nomApprenant;
	}

	public String getEmailApprenant() {
		return emailApprenant;
	}

	public void setEmailApprenant(String emailApprenant) {
		this.emailApprenant = emailApprenant;
	}
	
	
}
