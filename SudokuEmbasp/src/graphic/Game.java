package graphic;

import java.util.ArrayList;

import Percorsi.Punto;
import finishZone.BlueFinish;
import finishZone.PurpleFinish;
import finishZone.YellowFinish;
import main.Main;
import maps.Maps;
import player.BluePlayer;
import player.Player;
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

	public static BlueFinish blueFinish = new BlueFinish(9, 10);
	public static YellowFinish yellowFinish = new YellowFinish(10, 11);
	public static PurpleFinish purpleFinish = new PurpleFinish(9, 12);


	public Game() { // generazione map
		blocks = Maps.loadRoom(0);
	}

	public void move(int direction) {
		changePlayer(selectedPlayer);
		//clearpaths();

		if (direction < MOVE_RIGHT && direction > MOVE_DOWN)
			return;

		if (!collision(newX(direction), newY(direction))) {
			
			blocks[x][y].setType(Block.EMPTY);

			x = newX(direction);
			y = newY(direction);

			if (selectedPlayer == Block.BLUE_PLAYER) {
				if (blueBlock.getX() == x && blueBlock.getY() == y) {
					if (direction == MOVE_LEFT)
						if (blocks[x - 1][y].getType() != Block.WALL) {
							blueBlock.setX(x - 1);
							blocks[x - 1][y].setType(Block.BLUE_BLOCK);
						}
					if (direction == MOVE_RIGHT)
						if (blocks[x + 1][y].getType() != Block.WALL) {
							blueBlock.setX(x + 1);
							blocks[x + 1][y].setType(Block.BLUE_BLOCK);
						}
					if (direction == MOVE_DOWN)
						if (blocks[x][y + 1].getType() != Block.WALL) {
							blocks[x][y + 1].setType(Block.BLUE_BLOCK);
							blueBlock.setY(y + 1);
						}
					if (direction == MOVE_UP)
						if (blocks[x][y - 1].getType() != Block.WALL) {
							blocks[x][y - 1].setType(Block.BLUE_BLOCK);
							blueBlock.setY(y - 1);
						}
				}

				if (blueBlock.getX() == x && blueBlock.getY() == y) {
					return;
				}
				bluePlayer.setX(x);
				bluePlayer.setY(y);
			}
			if (selectedPlayer == Block.PURPLE_PLAYER) {
				if (purpleBlock.getX() == x && purpleBlock.getY() == y) {
					if (direction == MOVE_LEFT)
						if (blocks[x - 1][y].getType() != Block.WALL) {
							blocks[x - 1][y].setType(Block.PURPLE_BLOCK);
							purpleBlock.setX(x - 1);
						}
					if (direction == MOVE_RIGHT)
						if (blocks[x + 1][y].getType() != Block.WALL) {
							blocks[x + 1][y].setType(Block.PURPLE_BLOCK);
							purpleBlock.setX(x + 1);
						}
					if (direction == MOVE_DOWN)
						if (blocks[x][y + 1].getType() != Block.WALL) {
							blocks[x][y + 1].setType(Block.PURPLE_BLOCK);
							purpleBlock.setY(y + 1);
						}
					if (direction == MOVE_UP)
						if (blocks[x][y - 1].getType() != Block.WALL) {
							blocks[x][y - 1].setType(Block.PURPLE_BLOCK);
							purpleBlock.setY(y - 1);
						}
				}

				if (purpleBlock.getX() == x && purpleBlock.getY() == y) {
					return;
				}
				purplePlayer.setX(x);
				purplePlayer.setY(y);
			}
			if (selectedPlayer == Block.YELLOW_PLAYER) {
				if (yellowBlock.getX() == x && yellowBlock.getY() == y) {
					if (direction == MOVE_LEFT)
						if (blocks[x - 1][y].getType() != Block.WALL) {
							blocks[x - 1][y].setType(Block.YELLOW_BLOCK);
							yellowBlock.setX(x - 1);
						}
					if (direction == MOVE_RIGHT)
						if (blocks[x + 1][y].getType() != Block.WALL) {
							blocks[x + 1][y].setType(Block.YELLOW_BLOCK);
							yellowBlock.setX(x + 1);
						}
					if (direction == MOVE_DOWN)
						if (blocks[x][y + 1].getType() != Block.WALL) {
							blocks[x][y + 1].setType(Block.YELLOW_BLOCK);
							yellowBlock.setY(y + 1);
						}
					if (direction == MOVE_UP)
						if (blocks[x][y - 1].getType() != Block.WALL) {
							blocks[x][y - 1].setType(Block.YELLOW_BLOCK);
							yellowBlock.setY(y - 1);
						}
				}

				if (yellowBlock.getX() == x && yellowBlock.getY() == y) {
					return;
				}
				yellowPlayer.setX(x);
				yellowPlayer.setY(y);

			}

			blocks[x][y].setType(selectedPlayer);
			
		}

		if (blueBlock.getX() == blueFinish.getX() && blueBlock.getY() == blueFinish.getY())
			blueBlock.setOnFinish(true);
		else
			blueBlock.setOnFinish(false);

		if (purpleBlock.getX() == purpleFinish.getX() && purpleBlock.getY() == purpleFinish.getY())
			purpleBlock.setOnFinish(true);
		else
			purpleBlock.setOnFinish(false);

		if (yellowBlock.getX() == yellowFinish.getX() && yellowBlock.getY() == yellowFinish.getY())
			yellowBlock.setOnFinish(true);
		else
			yellowBlock.setOnFinish(false);

		if (blueBlock.getOnFinish() == true && yellowBlock.getOnFinish() == true && purpleBlock.getOnFinish() == true) {
			System.out.println("vittoria");
			if (Maps.index == 3)
				System.out.println("Fine gioco");
			else
				Maps.loadRoom(Maps.index + 1);
		}
		
		
		blocks[purpleFinish.getX()][purpleFinish.getY()].setType(Block.PURPLE_FINISH);
		blocks[blueFinish.getX()][blueFinish.getY()].setType(Block.BLUE_FINISH);
		blocks[yellowFinish.getX()][yellowFinish.getY()].setType(Block.YELLOW_FINISH);
		
		blocks[yellowBlock.getX()][yellowBlock.getY()].setType(Block.YELLOW_BLOCK);
		blocks[purpleBlock.getX()][purpleBlock.getY()].setType(Block.PURPLE_BLOCK);
		blocks[blueBlock.getX()][blueBlock.getY()].setType(Block.BLUE_BLOCK);
		
		
		
		/*if (Main.onMoveRefreshIA) {
			Main.startIA();
		}*/
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
	
	public void clearpaths() {
		for(int i=0; i<Main.listaPBlu.size(); i++) {
			if(Main.listaPBlu.get(i).getX() == bluePlayer.getX() && Main.listaPBlu.get(i).getY() == bluePlayer.getY()) {
				Main.listaPBlu.get(i).setType(0);
				Main.listaPBlu.get(i).setPassato(true);
			}
		}
		for(int i=0; i<Main.listaPercorsoBlu.size(); i++) {
			if(Main.listaPercorsoBlu.get(i).getX() == bluePlayer.getX() && Main.listaPercorsoBlu.get(i).getY() == bluePlayer.getY()) {
				Main.listaPercorsoBlu.get(i).setType(0);
				Main.listaPercorsoBlu.get(i).setPassato(true);
			}
		}
		
		for(int i=0; i<Main.listaPViola.size(); i++) {
			if(Main.listaPViola.get(i).getX() == purplePlayer.getX() && Main.listaPViola.get(i).getY() == purplePlayer.getY()) {
				Main.listaPViola.get(i).setType(0);
				Main.listaPViola.get(i).setPassato(true);
			}
		}
		
		for(int i=0; i<Main.listaPercorsoViola.size(); i++) {
			if(Main.listaPercorsoViola.get(i).getX() == purplePlayer.getX() && Main.listaPercorsoViola.get(i).getY() == purplePlayer.getY()) {
				Main.listaPercorsoViola.get(i).setType(0);
				Main.listaPercorsoViola.get(i).setPassato(true);
			}
		}
		for(int i=0; i<Main.listaPGiallo.size(); i++) {
			if(Main.listaPGiallo.get(i).getX() == yellowPlayer.getX() && Main.listaPGiallo.get(i).getY() == yellowPlayer.getY()) {
				Main.listaPGiallo.get(i).setType(0);
				Main.listaPGiallo.get(i).setPassato(true);
			}
		}
		
		for(int i=0; i<Main.listaPercorsoGiallo.size(); i++) {
			if(Main.listaPercorsoGiallo.get(i).getX() == yellowPlayer.getX() && Main.listaPercorsoGiallo.get(i).getY() == yellowPlayer.getY()) {
				Main.listaPercorsoGiallo.get(i).setType(0);
				Main.listaPercorsoGiallo.get(i).setPassato(true);
			}
		}
		
	}
	
	public void autoMove(ArrayList<Punto> listaPunto, Player player) {
		
		//System.out.println(player);
		int xb = player.getX();
		int yb = player.getY();
		int distanzaBlu = 100;
		int indiceBlu = 0;
		for(Punto i : listaPunto) {
			if (i.getPassato()==false) {
				int ix = i.getX();
				int iy = i.getY();
				int d = (ix - xb) + (iy - yb);
				if (d < distanzaBlu) {
					distanzaBlu = d;
					indiceBlu = listaPunto.indexOf(i);
				} 
			}
		}
		//System.out.println(listaPunto.get(indiceBlu).getX()+" "+listaPunto.get(indiceBlu).getY());
		if((xb-1)== listaPunto.get(indiceBlu).getX() && yb == listaPunto.get(indiceBlu).getY()) {
			System.out.println("sx");
			move(MOVE_LEFT);
		}
		if((xb+1)== listaPunto.get(indiceBlu).getX() && yb == listaPunto.get(indiceBlu).getY()) {
			System.out.println("dx");
			move(MOVE_RIGHT);
		}
		if(xb == listaPunto.get(indiceBlu).getX() && (yb-1) == listaPunto.get(indiceBlu).getY()) {
			System.out.println("up");
			move(MOVE_UP);
		}
		if(xb == listaPunto.get(indiceBlu).getX() && (yb+1) == listaPunto.get(indiceBlu).getY()) {
			System.out.println("dw");
			move(MOVE_DOWN);
		}
		
		clearpaths();
		Graphics.draw();
	}
	
}
