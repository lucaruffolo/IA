package graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PacmanGraphics extends StackPane {

	private Canvas canvas;
	private Game game;

	public PacmanGraphics(Game game) {
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
		
		/*
		 * canvas.getGraphicsContext2D().setFill(Color.BLUE);
		canvas.getGraphicsContext2D().fillOval(Game.BluePlayer.getX(), Game.BluePlayer.getY(), Settings.block, Settings.block);
		
		canvas.getGraphicsContext2D().setFill(Color.PURPLE);
		canvas.getGraphicsContext2D().fillOval(Game.PurplePlayer.getX(), Game.PurplePlayer.getY(), Settings.block, Settings.block);
		
		canvas.getGraphicsContext2D().setFill(Color.YELLOW);
		canvas.getGraphicsContext2D().fillOval(Game.YellowPlayer.getX(), Game.YellowPlayer.getY(), Settings.block, Settings.block);*/
		
		for (int i = 0; i < game.getBlocks().length; i++) {
			int x = i * Settings.block;
			for (int j = 0; j < game.getBlocks()[i].length; j++) {
				int y = j * Settings.block;
				switch (game.getBlocks()[i][j].getType()) {
				
				case Block.BLUE_PLAYER:
					canvas.getGraphicsContext2D().setFill(Color.BLUE);
					canvas.getGraphicsContext2D().fillOval(x, y, Settings.block, Settings.block);
					break;
				case Block.PURPLE_PLAYER:
					canvas.getGraphicsContext2D().setFill(Color.PURPLE);
					canvas.getGraphicsContext2D().fillOval(x, y, Settings.block, Settings.block);
					break;
				case Block.YELLOW_PLAYER:
					canvas.getGraphicsContext2D().setFill(Color.YELLOW);
					canvas.getGraphicsContext2D().fillOval(x, y, Settings.block, Settings.block);
					break;
					
				case Block.POINT:
					canvas.getGraphicsContext2D().setFill(Color.YELLOW);
					canvas.getGraphicsContext2D().fillOval(x + Settings.block / 4, y + Settings.block / 4,
							Settings.block / 2, Settings.block / 2);
					break;
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
