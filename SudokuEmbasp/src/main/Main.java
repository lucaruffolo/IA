package main;

import java.util.ArrayList;

import graphic.Block;
import graphic.Game;
import graphic.Graphics;
import graphic.PBlu;
import graphic.PGiallo;
import graphic.PViola;
import graphic.PercorsoBlu;
import graphic.PercorsoGiallo;
import graphic.PercorsoViola;
import graphic.Settings;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import maps.Maps;
import menu.MenuIniziale;

public class Main extends Application {

	public static Stage window;
	private static int N = 17;
	private static String encodingResource = "encodings/ccmmyy";
	private static Handler handler;
	public static Boolean onMoveRefreshIA = true;
	public static ArrayList<PercorsoBlu> listaPercorsoBlu;
	public static ArrayList<PercorsoGiallo> listaPercorsoGiallo;
	public static ArrayList<PercorsoViola> listaPercorsoViola;
	public static ArrayList<PBlu> listaPBlu;
	public static ArrayList<PViola> listaPViola;
	public static ArrayList<PGiallo> listaPGiallo;

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		
		window = primaryStage;
		FXMLLoader loader = new FXMLLoader(MenuIniziale.class.getResource("MenuIniziale.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		Scene menuIniziale = new Scene(root, 720, 480);
		primaryStage.centerOnScreen();
		primaryStage.setScene(menuIniziale);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public static void main(String[] args) {
		listaPercorsoBlu = new ArrayList<PercorsoBlu>();
		listaPercorsoGiallo = new ArrayList<PercorsoGiallo>();
		listaPercorsoViola = new ArrayList<PercorsoViola>();
		
		listaPBlu = new ArrayList<PBlu>();
		listaPGiallo = new ArrayList<PGiallo>();
		listaPViola = new ArrayList<PViola>();
		launch(args);
	}

	public static void startGame() {
		Game game = new Game();
		Graphics pg = new Graphics(game);
		Scene scene = new Scene(pg, Settings.size, Settings.size);
		window.centerOnScreen();
		window.setScene(scene);
		//pg.draw();
		//startIA();
		pg.draw();
		game.autoMove();
	}

	public static void startIA() {
		
		listaPercorsoBlu.clear();
		listaPercorsoGiallo.clear();
		listaPercorsoViola.clear();
		
		listaPBlu.clear();
		listaPViola.clear();
		listaPGiallo.clear();
		
		handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
		try {
			ASPMapper.getInstance().registerClass(Block.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e1) {
			e1.printStackTrace();
		}
		InputProgram facts = new ASPInputProgram();
		for (int i = 0; i < Settings.cellSize; i++) {
			for (int j = 0; j < Settings.cellSize; j++) {
				if (Maps.matrixGame[i][j].getType() != Block.NULLO) {
					try {
						facts.addObjectInput(new Block(i, j, Maps.matrixGame[i][j].getType()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		try {
			facts.addObjectInput(new PercorsoBlu(0, 0, 0));
			facts.addObjectInput(new PercorsoGiallo(0, 0, 0));
			facts.addObjectInput(new PercorsoViola(0, 0, 0));
			facts.addObjectInput(new PBlu(0,0,0));
			facts.addObjectInput(new PViola(0,0,0));
			facts.addObjectInput(new PGiallo(0,0,0));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		handler.addProgram(facts);
		InputProgram encoding = new ASPInputProgram();
		encoding.addFilesPath(encodingResource);
		handler.addProgram(encoding);
		Output o = handler.startSync();
		AnswerSets answersets = (AnswerSets) o;
		//answersets.getOptimalAnswerSets();

		// System.out.println("\n" + answersets.getAnswersets());
		int index = 1;

		for (AnswerSet a : answersets.getOptimalAnswerSets()) {
			// System.out.println(a);
			// System.out.println(answersets.getAnswersets().size());
			// System.out.println(a.getAnswerSet());

			index++;
	
			
			//if (index == answersets.getOptimalAnswerSets().size()) {
				// System.out.println("\n[Ottimo] (UltimoAS):");
				// System.out.println(a.getAnswerSet());
			try {
				for (Object obj : a.getAtoms()) {
					// System.out.println(obj);
					// System.out.println(a.getAtoms());
					if (obj instanceof PercorsoBlu) {
						PercorsoBlu cell = (PercorsoBlu) obj;
						if (cell.getType() == 1) {
							System.out.println("BLU: " + cell.getX() + "-" + cell.getY());
							listaPercorsoBlu.add(cell);
						}
					}
					if (obj instanceof PercorsoViola) {
						PercorsoViola cell = (PercorsoViola) obj;
						if (cell.getType() == 2) {
							listaPercorsoViola.add(cell);
							System.out.println("VIOLA: " + cell.getX() + "-" + cell.getY());
						}
					}
					if (obj instanceof PercorsoGiallo) {
						PercorsoGiallo cell = (PercorsoGiallo) obj;
						if (cell.getType() == 3) {
							System.out.println("GIALLO: " + cell.getX() + "-" + cell.getY());
							listaPercorsoGiallo.add(cell);

						}
					}
					if (obj instanceof PBlu) {
						PBlu cell = (PBlu) obj;
						if (cell.getType() == 1) {
							System.out.println("BLU pierpy: " + cell.getX() + "-" + cell.getY());
							listaPBlu.add(cell);
						}
					}
					if (obj instanceof PViola) {
						PViola cell = (PViola) obj;
						if (cell.getType() == 2) {
							System.out.println("VIOLA pierpy: " + cell.getX() + "-" + cell.getY());
							listaPViola.add(cell);
						}
					}
					if (obj instanceof PGiallo) {
						PGiallo cell = (PGiallo) obj;
						if (cell.getType() == 3) {
							System.out.println("GIALLO pierpy: " + cell.getX() + "-" + cell.getY());
							listaPGiallo.add(cell);
						}
					}
					
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
	}

}
