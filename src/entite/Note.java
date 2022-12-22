package entite;

public class Note {

	
	private int idNote;
	private int idApprenant;
	private int idFormation;
	private int Note[];
	
	public Note(int idNote, int idApprenant, int idFormation, int[] note) {
		super();
		this.idNote = idNote;
		this.idApprenant = idApprenant;
		this.idFormation = idFormation;
		Note = note;
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
	public int[] getNote() {
		return Note;
	}
	public void setNote(int[] note) {
		Note = note;
	}
	
	
}
