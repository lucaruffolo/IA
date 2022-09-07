package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import finishZone.BlueFinish;
import finishZone.PurpleFinish;
import finishZone.YellowFinish;
import graphic.Block;
import graphic.Game;
import graphic.Settings;
import player.BluePlayer;
import player.PurplePlayer;
import player.YellowPlayer;
import playerBlocks.BlueBlock;
import playerBlocks.PurpleBlock;
import playerBlocks.YellowBlock;


public class Maps {
	public static Block [][] matrixGame = new Block [Settings.cellSize][Settings.cellSize];
	public static int index = 0;
	
	public Maps() {
	}
	
	public static Block[][] loadRoom(int index) {

		Maps.index = index;
		ArrayList<ArrayList<Block>> matrix = new ArrayList<ArrayList<Block>>();
		try {
			  int riga = 0;
		      File myObj = new File("src\\maps\\level"+index);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] blocchi = data.split(" ");
		        matrix.add(new ArrayList<Block>());
		        for(String blocco : blocchi) {
		        	matrix.get(riga).add(new Block(Integer.parseInt(blocco)));
		        }
		        riga++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		for(int i=0; i<matrix.size(); i++) {
			for(int j=0; j<matrix.get(i).size(); j++) {
				matrixGame[i][j] = matrix.get(i).get(j);
				
				if(matrixGame[i][j].getType() == 1) {
					Game.bluePlayer = new BluePlayer(i, j);
				}
				if(matrixGame[i][j].getType() == 2) {
					Game.purplePlayer = new PurplePlayer(i, j);
				}
				if(matrixGame[i][j].getType() == 3) {
					Game.yellowPlayer = new YellowPlayer(i, j);
				}
				if(matrixGame[i][j].getType() == 6) {
					Game.blueBlock = new BlueBlock(i, j);
				}
				if(matrixGame[i][j].getType() == 7) {
					Game.purpleBlock = new PurpleBlock(i, j);
				}
				if(matrixGame[i][j].getType() == 8) {
					Game.yellowBlock = new YellowBlock(i, j);
				}
				if(matrixGame[i][j].getType() == 9) {
					Game.blueFinish = new BlueFinish(i, j);
				}
				if(matrixGame[i][j].getType() == 10) {
					Game.purpleFinish = new PurpleFinish(i, j);
				}
				if(matrixGame[i][j].getType() == 11) {
					Game.yellowFinish = new YellowFinish(i, j);
				}
			}
		}
		return matrixGame;
	}
}
