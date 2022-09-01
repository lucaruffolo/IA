package main;
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
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

import graphic.Game;
import graphic.PacmanGraphics;
import graphic.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import menu.MenuIniziale;

public class Main extends Application {

	public static Stage window;
	//public static Player player = new Blue_Player();

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
	}
}
