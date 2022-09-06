package graphic;

public class Block {

	public static final int EMPTY = 0;
	public static final int BLUE_PLAYER = 1;
	public static final int PURPLE_PLAYER = 2;
	public static final int YELLOW_PLAYER = 3;
	//public static final int POINT = 4;
	public static final int WALL = 5;
	public static final int BLUE_BLOCK = 6;
	public static final int PURPLE_BLOCK = 7;
	public static final int YELLOW_BLOCK = 8;
	public static final int BLUE_FINISH = 9;
	public static final int PURPLE_FINISH = 10;
	public static final int YELLOW_FINISH = 11;
	
	private int type;
	
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
