package entite;

public class FormationApprenant {
	
	private int idFormation;
	private int idApprenant;
	
	public FormationApprenant(int idFormation, int idApprenant) {
		super();
		this.idFormation = idFormation;
		this.idApprenant = idApprenant;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public int getIdApprenant() {
		return idApprenant;
	}

	public void setIdApprenant(int idApprenant) {
		this.idApprenant = idApprenant;
	}

}
