package graphic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("cell")
public class Block {

	public static final int EMPTY = 0;
	public static final int BLUE_PLAYER = 1;
	public static final int PURPLE_PLAYER = 2;
	public static final int YELLOW_PLAYER = 3;
	public static final int NULLO = 4;
	public static final int WALL = 5;
	public static final int BLUE_BLOCK = 6;
	public static final int PURPLE_BLOCK = 7;
	public static final int YELLOW_BLOCK = 8;
	public static final int BLUE_FINISH = 9;
	public static final int PURPLE_FINISH = 10;
	public static final int YELLOW_FINISH = 11;

	
	@Param(0)
	private int x;
	@Param(1)
	private int y;
	@Param(2)
	private int type;
	
	public Block(int x, int y, int type) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
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

	public Block(int type) {
		this.type = type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
