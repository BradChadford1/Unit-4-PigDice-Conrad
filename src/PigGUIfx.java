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
    GamePlay p1 = new GamePlay();
    GamePlay p2 = new GamePlay();

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

    private int currentPlayerTurn = 1;

    @Override
    public void start(Stage primaryStage) {

       Button roll = new Button("Roll");
       roll.setOnAction(this:: rollEvent);



        player1 = new Label("Player One:");
        p1d1 = new Label("D1:  " + p1.getD1());
        p1d2 = new Label("D2:  " + p1.getD2());
        sub1 = new Label("Subscore:  " + p1.getSubScore());
        tot1 = new Label("Total Score:  " + p1.getTotalScore());
        player2 =  new Label("Player Two:");
        p2d1 = new Label("D1:  " + p2.getD1());
        p2d2 = new Label("D2:  " + p2.getD2());
        sub2 = new Label("Subscore:  " + p2.getSubScore());
        tot2 = new Label("Total Score:  " + p2.getTotalScore());
    
    FlowPane pane1 = new FlowPane(player1, p1d1, p1d2, sub1, tot1);
    pane1.setHgap(15);
    
    FlowPane pane2 = new FlowPane(player2, p2d1, p2d2, sub2, tot2);
    pane2.setHgap(15);






        VBox root = new VBox(pane1, pane2, roll);
        Scene scene = new Scene(root, 400, 100);
        primaryStage.setTitle("Gameplay");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void rollEvent(ActionEvent event) {

    }

    public static void main(String[] args) {
        launch(args);
    }


}
