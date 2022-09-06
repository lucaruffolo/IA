package playerBlocks;

public class PurpleBlock {

	int x;
	int y;
	Boolean onFinish = false;

	public PurpleBlock(int x, int y) {
		super();
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
	public Boolean getOnFinish() {
		return onFinish;
	}

	public void setOnFinish(Boolean onFinish) {
		this.onFinish = onFinish;
	}

}
