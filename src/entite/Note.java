package entite;

public class Note {

	
	private int idNote;
	private int idApprenant;
	private int idFormation;
	private int Note1;
	private int Note2;
	private int Note3;
	private int Note4;
	
	public Note(int idNote, int idApprenant, int idFormation, int note1, int note2, int note3, int note4) {
		super();
		this.idNote = idNote;
		this.idApprenant = idApprenant;
		this.idFormation = idFormation;
		this.Note1 = note1;
		this.Note2 = note2;
		this.Note3 = note3;
		this.Note4 = note4;
	}

	public int getIdNote() {
		return idNote;
	}

	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	public int getIdApprenant() {
		return idApprenant;
	}

	public void setIdApprenant(int idApprenant) {
		this.idApprenant = idApprenant;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public int getNote1() {
		return Note1;
	}

	public void setNote1(int note1) {
		Note1 = note1;
	}

	public int getNote2() {
		return Note2;
	}

	public void setNote2(int note2) {
		Note2 = note2;
	}

	public int getNote3() {
		return Note3;
	}

	public void setNote3(int note3) {
		Note3 = note3;
	}

	public int getNote4() {
		return Note4;
	}

	public void setNote4(int note4) {
		Note4 = note4;
	}

	
	
}
