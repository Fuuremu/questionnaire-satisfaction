package entite;

public class Formateur {

	private int idFormateur;
	private String NomFormateur;
	
	public Formateur(int idFormateur, String NomFormateur) {
		this.idFormateur = idFormateur;
		this.NomFormateur = NomFormateur;
	}

	public int getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getNomFormateur() {
		return NomFormateur;
	}

	public void setNomFormateur(String nomFormateur) {
		NomFormateur = nomFormateur;
	}
}
