package graphic;

import java.util.Random;

public class Game {

	public final static int MOVE_RIGHT = 0;
	public final static int MOVE_LEFT = 1;
	public final static int MOVE_UP = 2;
	public final static int MOVE_DOWN = 3;
	
	private Block[][] blocks = new Block[Settings.cellSize][Settings.cellSize];
	
	private int x;
	private int y;
	public static int selectedPlayer = 1;
	
	public Game() { //generazione map
		
		for(int i = 0; i < blocks.length; i++) {
			for(int j = 0; j < blocks[i].length; j++) {
				blocks[i][j] = new Block(Block.EMPTY);
			}
		}
		
		blocks[1][8].setType(Block.BLUE_PLAYER);
		blocks[4][2].setType(Block.YELLOW_PLAYER);
		blocks[2][4].setType(Block.PURPLE_PLAYER);
		
		Random r = new Random();
		int count = 0;
		while(count < 4) {
			int randX = r.nextInt(Settings.cellSize);
			int randY = r.nextInt(Settings.cellSize);
			if(blocks[randX][randY].getType()==Block.EMPTY) {
				count++;
				blocks[randX][randY].setType(Block.POINT);
			}
		}
		
		count = 0;
		while(count < 4) {
			int randX = r.nextInt(Settings.cellSize-1)+1;
			for(int j = 0; j < blocks[randX].length/2; j++) {
				if(blocks[randX][j].getType()==Block.EMPTY) {
					blocks[randX][j].setType(Block.WALL);
				}
			}
			count++;		
		}
	}
	

	public void move(int direction) {
		changePlayer(selectedPlayer);
		if(direction < MOVE_RIGHT && direction > MOVE_DOWN)
			return;
		if(!collision(newX(direction), newY(direction))) {
			blocks[x][y].setType(Block.EMPTY);
			
			x = newX(direction);
			y = newY(direction);
			blocks[x][y].setType(selectedPlayer); //player
		//	GraphicsUtil.updateDirection(direction);
		}
	}
	
	public void changePlayer(int changePlayer) {
		selectedPlayer = changePlayer;
		if (selectedPlayer == 1) {
			for(int i = 0; i < blocks.length; i++) {
				for(int j = 0; j < blocks[i].length; j++) {
					if (blocks[i][j].getType() == 1) {
						x = i;
						y = j;
					}
				}
			}
		} else if (selectedPlayer == 2) {
			for(int i = 0; i < blocks.length; i++) {
				for(int j = 0; j < blocks[i].length; j++) {
					if (blocks[i][j].getType() == 2) {
						x = i;
						y = j;
					}
				}
			}
		}
		 else if (selectedPlayer == 3) {
			 for(int i = 0; i < blocks.length; i++) {
					for(int j = 0; j < blocks[i].length; j++) {
						if (blocks[i][j].getType() == 3) {
							x = i;
							y = j;
						}
					}
				}
		}
		
	}
	public int newX(int direction) {
		if(direction == MOVE_RIGHT)
			return (x+1)%Settings.cellSize;
		else if(direction == MOVE_LEFT) {
			if(x == 0)
				return Settings.cellSize-1;
			else
				return x-1;
		}
		return x;		
	}
	
	public int newY(int direction) {
		if(direction == MOVE_UP) {
			if(y == 0)
				return Settings.cellSize-1;
			else
				return y-1;
		}
		else if(direction == MOVE_DOWN)
			return (y+1)%Settings.cellSize;
		return y;
	}
	
	public boolean collision(int newX, int newY) {
		if(blocks[newX][newY].getType() == Block.WALL)
			return true;		
		return false;
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}


	public int getSelectedPlayer() {
		return selectedPlayer;
	}

 
	
	/*	int x = 0;
		int y = 0;
		if (player == 1) {
			x = xBlue;
			y = yBlue;
		} else if (player == 2) {
			x = xPurple;
			y = yPurple;
		}
		 else if (player == 3) {
			x = xYellow;
			y = yYellow;
		}*/
}
