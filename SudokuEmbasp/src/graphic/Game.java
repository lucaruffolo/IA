package graphic;

import finishZone.BlueFinish;
import finishZone.PurpleFinish;
import finishZone.YellowFinish;
import player.BluePlayer;
import player.PurplePlayer;
import player.YellowPlayer;
import playerBlocks.BlueBlock;
import playerBlocks.PurpleBlock;
import playerBlocks.YellowBlock;

public class Game {

	public final static int MOVE_RIGHT = 0;
	public final static int MOVE_LEFT = 1;
	public final static int MOVE_UP = 2;
	public final static int MOVE_DOWN = 3;

	private Block[][] blocks = new Block[Settings.cellSize][Settings.cellSize];

	private int x;
	private int y;
	public static int selectedPlayer = 1;

	public static BluePlayer bluePlayer = new BluePlayer(2, 2);
	public static YellowPlayer yellowPlayer = new YellowPlayer(3, 2);
	public static PurplePlayer purplePlayer = new PurplePlayer(4, 2);

	public static BlueBlock blueBlock = new BlueBlock(5, 5);
	public static YellowBlock yellowBlock = new YellowBlock(6, 8);
	public static PurpleBlock purpleBlock = new PurpleBlock(7, 5);

	public static BlueFinish blueFinish = new BlueFinish(9,10);
	public static YellowFinish yellowFinish = new YellowFinish(10,11);
	public static PurpleFinish purpleFinish = new PurpleFinish(9,12);
	
	public Game() { // generazione map

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				blocks[i][j] = new Block(Block.EMPTY);
			}
		}
		/*
		 * blocks[bluePlayer.getX()][bluePlayer.getY()].setType(Block.BLUE_PLAYER);
		 * blocks[yellowPlayer.getX()][yellowPlayer.getY()].setType(Block.YELLOW_PLAYER)
		 * ;
		 * blocks[purplePlayer.getX()][purplePlayer.getY()].setType(Block.PURPLE_PLAYER)
		 * ;
		 * 
		 * Random r = new Random(); int count = 0; while (count < 4) { int randX =
		 * r.nextInt(Settings.cellSize); int randY = r.nextInt(Settings.cellSize); if
		 * (blocks[randX][randY].getType() == Block.EMPTY) { count++;
		 * blocks[randX][randY].setType(Block.POINT); } }
		 * 
		 * Random r = new Random(); int count = 0; count = 0; while (count < 4) { int
		 * randX = r.nextInt(Settings.cellSize - 1) + 1; for (int j = 0; j <
		 * blocks[randX].length / 2; j++) { if (blocks[randX][j].getType() ==
		 * Block.EMPTY) { blocks[randX][j].setType(Block.WALL); } } count++; }
		 */

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (i == 0 || j == 0 || i == blocks.length - 1 || j == blocks[i].length - 1)
					blocks[i][j].setType(Block.WALL);
			}
		}

	}

	public void move(int direction) {
		changePlayer(selectedPlayer);

		if (direction < MOVE_RIGHT && direction > MOVE_DOWN)
			return;

		if (!collision(newX(direction), newY(direction))) {

			blocks[x][y].setType(Block.EMPTY);

			x = newX(direction);
			y = newY(direction);

			if (selectedPlayer == Block.BLUE_PLAYER) {
				if (blueBlock.getX() == x && blueBlock.getY() == y) {
					
					if (x == blueFinish.getX() && y == blueFinish.getY()) // una volta posizionato il blocco nel finishzone non si puo spostare piu
						return;
								
					if (direction == MOVE_LEFT)
						if (blocks[x - 1][y].getType() != Block.WALL)
							blueBlock.setX(x - 1);
					if (direction == MOVE_RIGHT)
						if (blocks[x + 1][y].getType() != Block.WALL)
							blueBlock.setX(x + 1);
					if (direction == MOVE_DOWN)
						if (blocks[x][y + 1].getType() != Block.WALL)
							blueBlock.setY(y + 1);
					if (direction == MOVE_UP)
						if (blocks[x][y - 1].getType() != Block.WALL)
							blueBlock.setY(y - 1);
				}

				if (blueBlock.getX() == x && blueBlock.getY() == y) {
					return;
				}
				bluePlayer.setX(x);
				bluePlayer.setY(y);
			}
			if (selectedPlayer == Block.PURPLE_PLAYER) {
				if (purpleBlock.getX() == x && purpleBlock.getY() == y) {
					
					if (x == purpleFinish.getX() && y == purpleFinish.getY()) // una volta posizionato il blocco nel finishzone non si puo spostare piu
						return;
					
					if (direction == MOVE_LEFT)
						if (blocks[x - 1][y].getType() != Block.WALL)
							purpleBlock.setX(x - 1);
					if (direction == MOVE_RIGHT)
						if (blocks[x + 1][y].getType() != Block.WALL)
							purpleBlock.setX(x + 1);
					if (direction == MOVE_DOWN)
						if (blocks[x][y + 1].getType() != Block.WALL)
							purpleBlock.setY(y + 1);
					if (direction == MOVE_UP)
						if (blocks[x][y - 1].getType() != Block.WALL)
							purpleBlock.setY(y - 1);
				}

				if (purpleBlock.getX() == x && purpleBlock.getY() == y) {
					return;
				}
				purplePlayer.setX(x);
				purplePlayer.setY(y);
			}
			if (selectedPlayer == Block.YELLOW_PLAYER) {
				if (yellowBlock.getX() == x && yellowBlock.getY() == y) {
					
					if (x == yellowFinish.getX() && y == yellowFinish.getY()) // una volta posizionato il blocco nel finishzone non si puo spostare piu
						return;
					
					if (direction == MOVE_LEFT)
						if (blocks[x - 1][y].getType() != Block.WALL)
							yellowBlock.setX(x - 1);
					if (direction == MOVE_RIGHT)
						if (blocks[x + 1][y].getType() != Block.WALL)
							yellowBlock.setX(x + 1);
					if (direction == MOVE_DOWN)
						if (blocks[x][y + 1].getType() != Block.WALL)
							yellowBlock.setY(y + 1);
					if (direction == MOVE_UP)
						if (blocks[x][y - 1].getType() != Block.WALL)
							yellowBlock.setY(y - 1);
				}

				if (yellowBlock.getX() == x && yellowBlock.getY() == y) {
					return;
				}
				yellowPlayer.setX(x);
				yellowPlayer.setY(y);

			}

			blocks[x][y].setType(selectedPlayer);
		}
	}

	public void changePlayer(int changePlayer) {
		selectedPlayer = changePlayer;

		if (selectedPlayer == Block.BLUE_PLAYER) {
			x = bluePlayer.getX();
			y = bluePlayer.getY();
		} else if (selectedPlayer == Block.PURPLE_PLAYER) {
			x = purplePlayer.getX();
			y = purplePlayer.getY();
		} else if (selectedPlayer == Block.YELLOW_PLAYER) {
			x = yellowPlayer.getX();
			y = yellowPlayer.getY();
		}
	}

	public int newX(int direction) {
		if (direction == MOVE_RIGHT)
			return (x + 1) % Settings.cellSize;
		else if (direction == MOVE_LEFT) {
			if (x == 0)
				return Settings.cellSize - 1;
			else
				return x - 1;
		}
		return x;
	}

	public int newY(int direction) {
		if (direction == MOVE_UP) {
			if (y == 0)
				return Settings.cellSize - 1;
			else
				return y - 1;
		} else if (direction == MOVE_DOWN)
			return (y + 1) % Settings.cellSize;
		return y;
	}

	public boolean collision(int newX, int newY) {
		if (blocks[newX][newY].getType() == Block.WALL)
			return true;
		return false;
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public int getSelectedPlayer() {
		return selectedPlayer;
	}

}
