package graphic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("pviola")
public class PViola {

	@Param(0)
	private int x;
	@Param(1)
	private int y;
	@Param(2)
	private int type;

	public PViola(int x, int y, int type) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public PViola() {

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
