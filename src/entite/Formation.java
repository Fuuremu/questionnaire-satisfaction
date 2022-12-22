package entite;

public class Formation {
	
	private int idFormation;
	private String ThemeFormation;
	private int idFormateur;
	private int TabApprenants[];
	
	public Formation(int idFormation, String themeFormation, int idFormateur, int[] tabApprenants) {
		super();
		this.idFormation = idFormation;
		ThemeFormation = themeFormation;
		this.idFormateur = idFormateur;
		TabApprenants = tabApprenants;
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

	public int[] getTabApprenants() {
		return TabApprenants;
	}

	public void setTabApprenants(int[] tabApprenants) {
		TabApprenants = tabApprenants;
	}
	
	
}
