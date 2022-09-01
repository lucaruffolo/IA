package logic;

public class Block {
	private Boolean arrived = false;
	private String colore;
	
	public Block() {
		
	}

	
	Boolean canBeMoved(Player p) {
		if(p.getColore() == colore)
			return true;
		return false;
		
	}
	
	public Boolean getArrived() {
		return arrived;
	}

	public void setArrived(Boolean arrived) {
		this.arrived = arrived;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}	
	
}
