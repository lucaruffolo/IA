package menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import main.Main;

public class MenuIniziale {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button bttEsci;

    @FXML
    private Button bttGioca;

    @FXML
    private Label lbl;

    @FXML
    void clickBttEsci(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void clickBttGioca(ActionEvent event) {
    	Main.startGame();
    }

}
