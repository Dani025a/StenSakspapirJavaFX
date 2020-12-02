package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    private static final String PAPER = "paper";
    private static final String STONE = "stone";
    private static final String SCISSORS = "scissors";
    private Image image;

    @FXML
    private Label playerScore;

    @FXML
    private Label computerScore;

    @FXML
    private ImageView player;

    @FXML
    private Label result;

    @FXML
    private ImageView computer;

    @FXML
    private void playerTurn(ActionEvent event) {
        String playerChoice = null;
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn":
                image = new Image("/Image/papir.png");
                playerChoice = PAPER;
                break;
            case "stoneBtn":
                image = new Image("/Image/sten.png");
                playerChoice = STONE;
                break;
            case "scissorsBtn":
                image = new Image("/Image/saks.png");
                playerChoice = SCISSORS;
                break;
        }
        player.setImage(image);

        winner(playerChoice, computerTurn());
    }

    private String computerTurn() {
        String computerChoice = null;
        int random = (int) (Math.random() * 100);

            if (random >= 0 && random <= 32){
                image = new Image("/Image/papir.png");
                computerChoice = PAPER;
            }
            else if (random >= 33 && random <=66) {
                image = new Image("/Image/sten.png");
                computerChoice = STONE;
            }
            else {
                image = new Image("/Image/saks.png");
                computerChoice = SCISSORS;
            }

        computer.setImage(image);
        return computerChoice;
    }

    public void playerWin() {
        result.setText("Du vandt!");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void computerWin() {
        result.setText("Du tabte!");
        computerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText()) + 1));
    }

    public void draw() {
        result.setText("Uafgjort!");
    }

    private void winner(String playerChoice, String computerChoice) {
       if (playerChoice.equals(STONE)){

           if (computerChoice.equals(SCISSORS))
               playerWin();
           else if (computerChoice.equals(PAPER))
               computerWin();
           else draw();

        }

       else if (playerChoice.equals(SCISSORS)){

           if (computerChoice.equals(PAPER))
               playerWin();
           else if (computerChoice.equals(STONE))
               computerWin();
           else draw();
       }

       else if (playerChoice.equals(PAPER)){

           if (computerChoice.equals(SCISSORS))
               computerWin();
           else if (computerChoice.equals(STONE))
               playerWin();
           else draw();
       }

    }
}
