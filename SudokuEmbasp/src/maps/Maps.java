package maps;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/*
0=muro
1=vuoto
2=viola Player
3=blu Player
4=giallo Player

5=blocco viola
6=blocco blu
7=blocco giallo
8=blocco rosso
9=blocco verde

10=finish viola
11=finish blu
12=finish giallo
13=finish rosso
14=finish verde
*/


public class Maps {

	private ArrayList<String> gameMaps;	
	
	private HashMap<String, File> association;
	
	public Maps() {
		initializeContainerMaps();
	}
	
	private void initializeContainerMaps() {
		File img1= new File("null");
		String map1 = new String("null");
		association.put(map1, img1);
		
		/*
		File img2= new File("null");
		String map2 = new String("null");
		association.put(map2, img2);
		
		File img3= new File("null");
		String map3 = new String("null");
		association.put(map3, img3);
		
		File img4= new File("null");
		String map4 = new String("null");
		association.put(map4, img4);
		
		File img5= new File("null");
		String map5 = new String("null");
		association.put(map5, img5);
		*/
		gameMaps.add(map1);
		/*
		gameMaps.add(map2);
		gameMaps.add(map3);
		gameMaps.add(map4);
		gameMaps.add(map5);
		*/
	}

	public ArrayList<String> getGameMaps() {
		return gameMaps;
	}

	public void setGameMaps(ArrayList<String> gameMaps) {
		this.gameMaps = gameMaps;
	}

	public HashMap<String, File> getAssociation() {
		return association;
	}

	public void setAssociation(HashMap<String, File> association) {
		this.association = association;
	}
}
