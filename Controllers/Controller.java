package TicTacToe.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {

    @FXML
    private Button boardButton;

    @FXML
    private Label lblPlayer;

    @FXML
    private Label lblScore;

    @FXML
    private Label lblScore2;

    private ArrayList<Button> btn = new ArrayList<>();
    private boolean player;

    public void setGo(String btnText){
        if (btn.size() % 2 == 0){
            player = true;
        }
        if (player) {
            lblPlayer.setText("Player 1 - X");
            boardButton.setText("X");
            btn.add(boardButton);
            player = false;
        } else {
            lblPlayer.setText("Player 2 - O");
            boardButton.setText("O");
            btn.add(boardButton);
            player = true;
        }
    }


    public void GameMouseClick(MouseEvent mouseEvent) {
        boardButton = (Button) mouseEvent.getSource();
        String btnText = boardButton.getText();

        switch (btnText){
            case "-":
                setGo(btnText);
                break;
        }
    }

    public void RestartMouseClick(MouseEvent mouseEvent) {
        for (Button buttons : btn) {
            buttons.setText("-");
        }

        lblPlayer.setText("Begin");
    }

    public void pointClick(MouseEvent mouseEvent) {
        int score = Integer.parseInt(lblScore.getText());
        lblScore.setText(String.valueOf(score + 1));
    }

    public void pointClick2(MouseEvent mouseEvent) {
        int score = Integer.parseInt(lblScore2.getText());
        lblScore2.setText(String.valueOf(score + 1));
    }
}
