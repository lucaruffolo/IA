package graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import main.Main;
import maps.Maps;

public class Graphics extends StackPane {

	private Canvas canvas;
	private Game game;

	public Graphics(Game game) {
		this.game = game;
		canvas = new Canvas();
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(new MovementController(game, this));
		getChildren().add(canvas);
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
	}

	public void draw() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		
		// disegno i player e do priorit� a quello scelto cosi da tenerlo sempre in vista
		if (Game.selectedPlayer == Block.BLUE_PLAYER) {	
		
			canvas.getGraphicsContext2D().setFill(Color.LIGHTPINK);
			canvas.getGraphicsContext2D().fillRect(Game.purpleFinish.getX()* Settings.block, Game.purpleFinish.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.LIGHTYELLOW);
			canvas.getGraphicsContext2D().fillRect(Game.yellowFinish.getX()* Settings.block, Game.yellowFinish.getY()* Settings.block,  Settings.block,   Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillOval(Game.purplePlayer.getX()* Settings.block, Game.purplePlayer.getY()* Settings.block, Settings.block, Settings.block);		
			canvas.getGraphicsContext2D().setFill(Color.YELLOW);
			canvas.getGraphicsContext2D().fillOval(Game.yellowPlayer.getX()* Settings.block, Game.yellowPlayer.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillRect(Game.purpleBlock.getX()* Settings.block, Game.purpleBlock.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.YELLOW);
			canvas.getGraphicsContext2D().fillRect(Game.yellowBlock.getX()* Settings.block, Game.yellowBlock.getY()* Settings.block, Settings.block, Settings.block);			
			
			//priorita al disegno:
			canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
			canvas.getGraphicsContext2D().fillRect(Game.blueFinish.getX()* Settings.block, Game.blueFinish.getY()* Settings.block,  Settings.block,   Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillOval(Game.bluePlayer.getX()* Settings.block, Game.bluePlayer.getY()* Settings.block,  Settings.block,   Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillRect(Game.blueBlock.getX()* Settings.block, Game.blueBlock.getY()* Settings.block,  Settings.block,   Settings.block);	
			if (Main.listaPercorsoBlu.size() > 0) {
				for(PercorsoBlu i: Main.listaPercorsoBlu) {
					canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
					canvas.getGraphicsContext2D().fillOval(i.getX()* Settings.block+10, i.getY()* Settings.block+10 ,  Settings.block*0.5,   Settings.block*0.5);
				}
			}
			if (Main.listaPBlu.size() > 0) {
				for(PBlu i: Main.listaPBlu) {
					canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
					canvas.getGraphicsContext2D().fillOval(i.getX()* Settings.block+10, i.getY()* Settings.block+10 ,  Settings.block*0.5,   Settings.block*0.5);
				}
			}
		} else if (Game.selectedPlayer == Block.YELLOW_PLAYER) {
			
			canvas.getGraphicsContext2D().setFill(Color.LIGHTPINK);
			canvas.getGraphicsContext2D().fillRect(Game.purpleFinish.getX()* Settings.block, Game.purpleFinish.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
			canvas.getGraphicsContext2D().fillRect(Game.blueFinish.getX()* Settings.block, Game.blueFinish.getY()* Settings.block,  Settings.block,   Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillOval(Game.purplePlayer.getX()* Settings.block, Game.purplePlayer.getY()* Settings.block, Settings.block, Settings.block);	
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillOval(Game.bluePlayer.getX()* Settings.block, Game.bluePlayer.getY()* Settings.block,  Settings.block,   Settings.block);		
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillRect(Game.blueBlock.getX()* Settings.block, Game.blueBlock.getY()* Settings.block,  Settings.block,   Settings.block);		
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillRect(Game.purpleBlock.getX()* Settings.block, Game.purpleBlock.getY()* Settings.block, Settings.block, Settings.block);			
			
			//priorita al disegno:
			canvas.getGraphicsContext2D().setFill(Color.LIGHTYELLOW);
			canvas.getGraphicsContext2D().fillRect(Game.yellowFinish.getX()* Settings.block, Game.yellowFinish.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.YELLOW);			
			canvas.getGraphicsContext2D().fillRect(Game.yellowBlock.getX()* Settings.block, Game.yellowBlock.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.YELLOW);
			canvas.getGraphicsContext2D().fillOval(Game.yellowPlayer.getX()* Settings.block, Game.yellowPlayer.getY()* Settings.block, Settings.block, Settings.block);
			if (Main.listaPercorsoGiallo.size() > 0) {
				for(PercorsoGiallo i: Main.listaPercorsoGiallo) {
					canvas.getGraphicsContext2D().setFill(Color.DARKGOLDENROD);
					canvas.getGraphicsContext2D().fillOval(i.getX()* Settings.block+10, i.getY()* Settings.block+10 ,  Settings.block*0.5,   Settings.block*0.5);
				}
			}
			if (Main.listaPGiallo.size() > 0) {
				for(PGiallo i: Main.listaPGiallo) {
					canvas.getGraphicsContext2D().setFill(Color.DARKGOLDENROD);
					canvas.getGraphicsContext2D().fillOval(i.getX()* Settings.block+10, i.getY()* Settings.block+10 ,  Settings.block*0.5,   Settings.block*0.5);
				}
			}
		}else if (Game.selectedPlayer == Block.PURPLE_PLAYER) {
			canvas.getGraphicsContext2D().setFill(Color.LIGHTYELLOW);
			canvas.getGraphicsContext2D().fillRect(Game.yellowFinish.getX()* Settings.block, Game.yellowFinish.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
			canvas.getGraphicsContext2D().fillRect(Game.blueFinish.getX()* Settings.block, Game.blueFinish.getY()* Settings.block,  Settings.block,   Settings.block);			
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillOval(Game.bluePlayer.getX()* Settings.block, Game.bluePlayer.getY()* Settings.block,  Settings.block,   Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.YELLOW);
			canvas.getGraphicsContext2D().fillOval(Game.yellowPlayer.getX()* Settings.block, Game.yellowPlayer.getY()* Settings.block, Settings.block, Settings.block);			
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillRect(Game.blueBlock.getX()* Settings.block, Game.blueBlock.getY()* Settings.block,  Settings.block,   Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.YELLOW);
			canvas.getGraphicsContext2D().fillRect(Game.yellowBlock.getX()* Settings.block, Game.yellowBlock.getY()* Settings.block, Settings.block, Settings.block);

			//priorita al disegno:
			canvas.getGraphicsContext2D().setFill(Color.LIGHTPINK);
			canvas.getGraphicsContext2D().fillRect(Game.purpleFinish.getX()* Settings.block, Game.purpleFinish.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillRect(Game.purpleBlock.getX()* Settings.block, Game.purpleBlock.getY()* Settings.block, Settings.block, Settings.block);
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillOval(Game.purplePlayer.getX()* Settings.block, Game.purplePlayer.getY()* Settings.block, Settings.block, Settings.block);	
			if (Main.listaPercorsoViola.size() > 0) {
				for(PercorsoViola i: Main.listaPercorsoViola) {
					canvas.getGraphicsContext2D().setFill(Color.DARKVIOLET);
					canvas.getGraphicsContext2D().fillOval(i.getX()* Settings.block+10, i.getY()* Settings.block+10 ,  Settings.block*0.5,   Settings.block*0.5);
				}
			}
			if (Main.listaPViola.size() > 0) {
				for(PViola i: Main.listaPViola) {
					canvas.getGraphicsContext2D().setFill(Color.DARKVIOLET);
					canvas.getGraphicsContext2D().fillOval(i.getX()* Settings.block+10, i.getY()* Settings.block+10 ,  Settings.block*0.5,   Settings.block*0.5);
				}
			}
		}
		
		
		
		
		
		for (int i = 0; i < game.getBlocks().length; i++) {
			int x = i * Settings.block;
			for (int j = 0; j < game.getBlocks()[i].length; j++) {
				int y = j * Settings.block;
				switch (game.getBlocks()[i][j].getType()) {
				/*
				case Block.POINT: 
					canvas.getGraphicsContext2D().setFill(Color.YELLOW);
					canvas.getGraphicsContext2D().fillOval(x + Settings.block / 4, y + Settings.block / 4,
							Settings.block / 2, Settings.block / 2);
					break;*/
				case Block.WALL:
					canvas.getGraphicsContext2D().setFill(Color.BLUE);
					canvas.getGraphicsContext2D().fillRect(x + Settings.block / 4, y, Settings.block * 0.5,
							Settings.block * 0.9);
					break;
				default:
					break;
				}
			}
		}
		
		
		 
	}
}
