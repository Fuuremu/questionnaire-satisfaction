package entite;

public class Formation {
	
	private int idFormation;
	private String ThemeFormation;
	private int idFormateur;
	
	public Formation(int idFormation, String themeFormation, int idFormateur) {
		super();
		this.idFormation = idFormation;
		ThemeFormation = themeFormation;
		this.idFormateur = idFormateur;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public String getThemeFormation() {
		return ThemeFormation;
	}

	public void setThemeFormation(String themeFormation) {
		ThemeFormation = themeFormation;
	}

	public int getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}

}
