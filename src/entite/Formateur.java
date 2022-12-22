package entite;

public class Formateur {

	private int idFormateur;
	private String nomFormateur;
	private String prenomFormateur;
	
	public Formateur(int idFormateur, String NomFormateur, String PrenomFormateur) {
		this.idFormateur = idFormateur;
		this.nomFormateur = NomFormateur;
		this.prenomFormateur = PrenomFormateur;
	}

	public int getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getNomFormateur() {
		return nomFormateur;
	}

	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}

	public String getPrenomFormateur() {
		return prenomFormateur;
	}

	public void setPrenomFormateur(String prenomFormateur) {
		this.prenomFormateur = prenomFormateur;
	}



	
}
