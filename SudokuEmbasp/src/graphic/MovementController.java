package graphic;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MovementController implements EventHandler<KeyEvent> {

	private Game game;
	private PacmanGraphics graphics;

	public MovementController(Game game, PacmanGraphics graphics) {
		this.game = game;
		this.graphics = graphics;
	}

	@Override
	public void handle(KeyEvent e) {
		switch (e.getCode()) {
		case LEFT:
			game.move(Game.MOVE_LEFT);
			graphics.draw();
			break;
		case RIGHT:
			game.move(Game.MOVE_RIGHT);
			graphics.draw();
			break;
		case UP:
			game.move(Game.MOVE_UP);
			graphics.draw();
			break;
		case DOWN:
			game.move(Game.MOVE_DOWN);
			graphics.draw();
			break;
		case SPACE:
			int changePlayer = game.getSelectedPlayer() + 1;
			if (changePlayer > 3)
				changePlayer = 1; 
			 game.changePlayer(changePlayer);
			 
			graphics.draw();
			break;
		case ESCAPE:
			if (graphics.getScene().getWindow() instanceof Stage) {
				Stage stage = (Stage) graphics.getScene().getWindow();
				stage.close();
			}
		default:
			break;
		}
	}

}
