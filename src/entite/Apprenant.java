package entite;

public class Apprenant {

	private int idApprenant;
	private String nomApprenant;
	private String prenomApprenant;
	private String emailApprenant; //adresse email
	
	public Apprenant(String nomApprenant, String prenomApprenant, String emailApprenant) {
		super();
		this.nomApprenant = nomApprenant;
		this.prenomApprenant = prenomApprenant;
		this.emailApprenant = emailApprenant;
	}
	public Apprenant(String nomApprenant, String prenomApprenant) {  
        this(nomApprenant,prenomApprenant, "indéfini") ;  // appel du constructeur de même classe  
   }  

	public int getIdApprenant() {
		return this.idApprenant;
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

	public String getPrenomApprenant() {
		return prenomApprenant;
	}

	public void setPrenomApprenant(String prenomApprenant) {
		this.prenomApprenant = prenomApprenant;
	}

	public String getEmailApprenant() {
		return emailApprenant;
	}

	public void setEmailApprenant(String emailApprenant) {
		this.emailApprenant = emailApprenant;
	}

	
}
