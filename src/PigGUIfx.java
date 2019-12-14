import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


import javax.swing.*;


public class PigGUIfx extends Application {
    private GamePlay p1 = new GamePlay();
    private GamePlay p2 = new GamePlay();

    private Turn turn = new Turn();
    
    private Label player1;
    private Label p1d1;
    private Label p1d2;
    private Label sub1;
    private Label tot1;
    private Label player2;
    private Label p2d1;
    private Label p2d2;
    private Label sub2;
    private Label tot2;

    private Rectangle indicator;



   @Override
    public void start(Stage primaryStage) {

        Button roll = new Button("Roll");
        roll.setOnAction(this:: rollEvent);

        Button pass = new Button("Pass");
        pass.setOnAction(this:: passEvent);

        player1 = new Label("Player One:");
        p1d1 = new Label("D1:  --");
        p1d2 = new Label("D2:  --");
        sub1 = new Label("Subscore:  --");
        tot1 = new Label("Total Score:  --");

        player2 =  new Label("Player Two:");
        p2d1 = new Label("D1:  --");
        p2d2 = new Label("D2:  --");
        sub2 = new Label("Subscore:  --");
        tot2 = new Label("Total Score:  --");

        indicator = new Rectangle(65,18);
        indicator.setY(0);
        indicator.setX(0);
        indicator.setStroke(Color.BLACK);
        indicator.setFill(Color.WHITE);
        indicator.setStrokeWidth(2);

    FlowPane pane1 = new FlowPane(player1, p1d1, p1d2, sub1, tot1);
    pane1.setHgap(15);
    
    FlowPane pane2 = new FlowPane(player2, p2d1, p2d2, sub2, tot2);
    pane2.setHgap(15);

    FlowPane pane3 = new FlowPane(roll, pass);
    pane3.setHgap(35);

    VBox root = new VBox(pane1, pane2, pane3);
    Group root2 = new Group(indicator, root);
    Scene scene = new Scene(root2, 400,100);

    primaryStage.setTitle("Pig Dice");
    primaryStage.setScene(scene);
    primaryStage.show();

    }

    private void rollEvent(ActionEvent event) {
        if (turn.isOdd()) {
            p1.rollToScore();
            if ((p1.getD1() == 1) && (p1.getD2() == 1)) {
                p1.setSubScore(0);
                p1.setTotalScore(0);
                p1.pass();
                p1d1.setText("D1:  " + p1.getD1());
                p1d2.setText("D2:  " + p1.getD2());
                sub1.setText("Sub Score:  " + p1.getSubScore());
                tot1.setText("Total Score:  " + p1.getTotalScore());
                turn.passTurn();
                indicator.setX(0);
                indicator.setY(15);
            }
            if ((p1.getD1() == 1) || (p1.getD2() == 1)) {
                p1.setSubScore(0);
                p1.pass();
                p1d1.setText("D1:  " + p1.getD1());
                p1d2.setText("D2:  " + p1.getD2());
                sub1.setText("Sub Score:  " + p1.getSubScore());
                tot1.setText("Total Score:  " + p1.getTotalScore());
                turn.passTurn();
                indicator.setX(0);
                indicator.setY(15);
            }
            else {
                p1d1.setText("D1:  " + p1.getD1());
                p1d2.setText("D2:  " + p1.getD2());
                sub1.setText("Sub Score:  " + p1.getSubScore());
                indicator.setX(0);
                indicator.setY(0);
            }

        }
        else {
            p2.rollToScore();
            if ((p2.getD1() == 1) && (p2.getD2() == 1)) {
                p2.setSubScore(0);
                p2.setTotalScore(0);
                p2.pass();
                p2d1.setText("D1:  " + p2.getD1());
                p2d2.setText("D2:  " + p2.getD2());
                sub2.setText("Sub Score:  " + p2.getSubScore());
                tot2.setText("Total Score:  " + p2.getTotalScore());
                turn.passTurn();
                indicator.setX(0);
                indicator.setY(0);
            }
            if ((p2.getD1() == 1) || (p2.getD2() == 1)) {
                p2.setSubScore(0);
                p2.pass();
                p2d1.setText("D1:  " + p2.getD1());
                p2d2.setText("D2:  " + p2.getD2());
                sub2.setText("Sub Score:  " + p2.getSubScore());
                tot2.setText("Total Score:  " + p2.getTotalScore());
                turn.passTurn();
                indicator.setX(0);
                indicator.setY(0);
            }
            else {
                p2d1.setText("D1:  " + p2.getD1());
                p2d2.setText("D2:  " + p2.getD2());
                sub2.setText("Sub Score:  " + p2.getSubScore());
                indicator.setX(0);
                indicator.setY(15);
            }
        }
    }

    private void passEvent(ActionEvent event) {
        if (turn.isOdd()) {
            p1.pass();
            p1.setSubScore(0);
            p1d1.setText("D1:  --");
            p1d2.setText("D2:  --");
            sub1.setText("Sub Score:  --");
            tot1.setText("Total Score:  " + p1.getTotalScore());
            turn.passTurn();
            indicator.setX(0);
            indicator.setY(15);
        }
        else {
            p2.pass();
            p2.setSubScore(0);
            p2d1.setText("D1:  --");
            p2d2.setText("D2:  --");
            sub2.setText("Sub Score:  --");
            tot2.setText("Total Score:  " + p2.getTotalScore());
            turn.passTurn();
            indicator.setX(0);
            indicator.setY(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
