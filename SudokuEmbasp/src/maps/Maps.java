package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import graphic.Block;
import graphic.Settings;


public class Maps {
	static Block [][] matrixGame = new Block [Settings.cellSize][Settings.cellSize];
	public static int index = 0;
	
	public Maps() {
	}
	
	public static Block[][] loadRoom(int index) {
		System.out.println(Paths.get("lee.txt").toAbsolutePath());

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
			}
		}
		return matrixGame;
	}
}
