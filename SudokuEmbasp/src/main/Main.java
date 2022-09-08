package main;

import java.lang.reflect.InvocationTargetException;

import graphic.Block;
import graphic.Game;
import graphic.PacmanGraphics;
import graphic.Settings;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
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
import javafx.scene.control.Cell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import maps.Maps;
import menu.MenuIniziale;

public class Main extends Application {

	public static Stage window;
	private static int N = 17;
	private static String encodingResource = "encodings/ccmmyy";
	private static Handler handler;

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
		launch(args);
	}

	public static void startGame() {
		Game game = new Game();
		PacmanGraphics pg = new PacmanGraphics(game);
		Scene scene = new Scene(pg, Settings.size, Settings.size);
		window.centerOnScreen();
		window.setScene(scene);
		pg.draw();
		startIA();
	}

	public static void startIA() {
		handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
		try {
			ASPMapper.getInstance().registerClass(Block.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e1) {
			e1.printStackTrace();
		}
		InputProgram facts = new ASPInputProgram();
		for (int i = 0; i < Settings.cellSize; i++) {
			for (int j = 0; j < Settings.cellSize; j++) {
				if (Maps.matrixGame[i][j].getType() != Block.WALL && Maps.matrixGame[i][j].getType() != Block.NULLO) {
					try {
						facts.addObjectInput(new Block(i, j, Maps.matrixGame[i][j].getType()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		handler.addProgram(facts);
		InputProgram encoding = new ASPInputProgram();
		encoding.addFilesPath(encodingResource);
		handler.addProgram(encoding);
		Output o = handler.startSync();
		AnswerSets answersets = (AnswerSets) o;
		
			 
		//System.out.println("\n" + answersets.getAnswersets());
			
		for (AnswerSet a : answersets.getAnswersets()) {	
			//System.out.println(a);
			//System.out.println(a.getAnswerSet());

			try {
				for (Object obj : a.getAtoms()) {
					//System.out.println(obj);
					//System.out.println(a.getAtoms());
					if (!(obj instanceof Block))
						continue;

					Block cell = (Block) obj;
					//System.out.println(cell.getX());
					//System.out.println(cell.getY());
					Maps.matrixGame[cell.getX()][cell.getY()].setType(cell.getType());
					
					/*
					for (int i = 0; i < 17; i++) {
						for (int j = 0; j < 17; j++) {
							System.out.print(Maps.matrixGame[i][j].getType() +" ");
						}
						System.out.println();
					}*/
					
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}

		
	}

}
