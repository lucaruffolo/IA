package Percorsi;

public interface Punto {
	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);
	
	public void setType(int type);

	public int getType();

	public Boolean getPassato();

	public void setPassato(Boolean passato);
}
