import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class PigGUIfx extends Application {
    private GamePlay p1 = new GamePlay();
    private GamePlay p2 = new GamePlay();

    private Turn turn = new Turn();
    
    private Label player1,p1d1,p1d2,sub1,tot1,player2,p2d1,p2d2,sub2,tot2;

    private TextField nameOne, nameTwo;
    private TextArea win1, win2;

    private Rectangle indicator;

    private Scene gameScene, firstScene;
    private Scene scene1;
    private Scene scene2;

    public PigGUIfx() {
    }

    @Override
    public void start(Stage primaryStage) {
        nameOne = new TextField();
        nameOne.setPromptText("Insert player one name here");
        nameOne.setPrefWidth(175);
        nameOne.setEditable(true);
        nameOne.setFocusTraversable(false);
        nameTwo = new TextField();
        nameTwo.setPromptText("Insert player two name here");
        nameTwo.setPrefWidth(175);
        nameTwo.setEditable(true);
        nameTwo.setFocusTraversable(false);

        TextArea logo1 = new TextArea("░░░░░░▄██████████████▄░░░░░░░ \n░░░░▄██████████████████▄░░░░░ \n░░░█▀░░░░░░░░░░░▀▀███████░░░░ \n░░█▌░░░░░░░░░░░░░░░▀██████░░░ \n░█▌░░░░░░░░░░░░░░░░███████▌░░ \n░█░░░░░░░░░░░░░░░░░████████░░ \n▐▌░░░░░░░░░░░░░░░░░▀██████▌░░ \n░▌▄███▌░░░░▀████▄░░░░▀████▌░░ \n▐▀▀▄█▄░▌░░░▄██▄▄▄▀░░░░████▄▄░ \n▐░▀░░═▐░░░░░░══░░▀░░░░▐▀░▄▀▌▌ \n▐░░░░░▌░░░░░░░░░░░░░░░▀░▀░░▌▌ \n▐░░░▄▀░░░▀░▌░░░░░░░░░░░░▌█░▌▌ \n░▌░░▀▀▄▄▀▀▄▌▌░░░░░░░░░░▐░▀▐▐░ \n░▌░░▌░▄▄▄▄░░░▌░░░░░░░░▐░░▀▐░░ \n░█░▐▄██████▄░▐░░░░░░░░█▀▄▄▀░░ \n░▐░▌▌░░░░░░▀▀▄▐░░░░░░█▌░░░░░░ \n░░█░░▄▀▀▀▀▄░▄═╝▄░░░▄▀░▌░░░░░░ \n░░░▌▐░░░░░░▌░▀▀░░▄▀░░▐░░░░░░░ \n░░░▀▄░░░░░░░░░▄▀▀░░░░█░░░░░░░ \n░░░▄█▄▄▄▄▄▄▄▀▀░░░░░░░▌▌░░░░░░ \n░░▄▀▌▀▌░░░░░░░░░░░░░▄▀▀▄░░░░░ \n▄▀░░▌░▀▄░░░░░░░░░░▄▀░░▌░▀▄░░░ \n░░░░▌█▄▄▀▄░░░░░░▄▀░░░░▌░░░▌▄▄ \n░░░▄▐██████▄▄░▄▀░░▄▄▄▄▌░░░░▄░ \n░░▄▌████████▄▄▄███████▌░░░░░▄ \n░▄▀░██████████████████▌▀▄░░░░ \n▀░░░█████▀▀░░░▀███████░░░▀▄░░ \n░░░░▐█▀░░░▐░░░░░▀████▌░░░░▀▄░ \n░░░░░░▌░░░▐░░░░▐░░▀▀█░░░░░░░▀ \n░░░░░░▐░░░░▌░░░▐░░░░░▌░░░░░░░ \n░╔╗║░╔═╗░═╦═░░░░░╔╗░░╔═╗░╦═╗░ \n░║║║░║░║░░║░░░░░░╠╩╗░╠═╣░║░║░ \n░║╚╝░╚═╝░░║░░░░░░╚═╝░║░║░╩═╝░ \n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        logo1.setEditable(false);
        logo1.setPrefSize(70,137.5);
        logo1.setFont(Font.font(3));
        logo1.setLayoutX(250);
        logo1.setLayoutY(5);

        TextArea logo2 = new TextArea("░░░░░░▄██████████████▄░░░░░░░ \n░░░░▄██████████████████▄░░░░░ \n░░░█▀░░░░░░░░░░░▀▀███████░░░░ \n░░█▌░░░░░░░░░░░░░░░▀██████░░░ \n░█▌░░░░░░░░░░░░░░░░███████▌░░ \n░█░░░░░░░░░░░░░░░░░████████░░ \n▐▌░░░░░░░░░░░░░░░░░▀██████▌░░ \n░▌▄███▌░░░░▀████▄░░░░▀████▌░░ \n▐▀▀▄█▄░▌░░░▄██▄▄▄▀░░░░████▄▄░ \n▐░▀░░═▐░░░░░░══░░▀░░░░▐▀░▄▀▌▌ \n▐░░░░░▌░░░░░░░░░░░░░░░▀░▀░░▌▌ \n▐░░░▄▀░░░▀░▌░░░░░░░░░░░░▌█░▌▌ \n░▌░░▀▀▄▄▀▀▄▌▌░░░░░░░░░░▐░▀▐▐░ \n░▌░░▌░▄▄▄▄░░░▌░░░░░░░░▐░░▀▐░░ \n░█░▐▄██████▄░▐░░░░░░░░█▀▄▄▀░░ \n░▐░▌▌░░░░░░▀▀▄▐░░░░░░█▌░░░░░░ \n░░█░░▄▀▀▀▀▄░▄═╝▄░░░▄▀░▌░░░░░░ \n░░░▌▐░░░░░░▌░▀▀░░▄▀░░▐░░░░░░░ \n░░░▀▄░░░░░░░░░▄▀▀░░░░█░░░░░░░ \n░░░▄█▄▄▄▄▄▄▄▀▀░░░░░░░▌▌░░░░░░ \n░░▄▀▌▀▌░░░░░░░░░░░░░▄▀▀▄░░░░░ \n▄▀░░▌░▀▄░░░░░░░░░░▄▀░░▌░▀▄░░░ \n░░░░▌█▄▄▀▄░░░░░░▄▀░░░░▌░░░▌▄▄ \n░░░▄▐██████▄▄░▄▀░░▄▄▄▄▌░░░░▄░ \n░░▄▌████████▄▄▄███████▌░░░░░▄ \n░▄▀░██████████████████▌▀▄░░░░ \n▀░░░█████▀▀░░░▀███████░░░▀▄░░ \n░░░░▐█▀░░░▐░░░░░▀████▌░░░░▀▄░ \n░░░░░░▌░░░▐░░░░▐░░▀▀█░░░░░░░▀ \n░░░░░░▐░░░░▌░░░▐░░░░░▌░░░░░░░ \n░╔╗║░╔═╗░═╦═░░░░░╔╗░░╔═╗░╦═╗░ \n░║║║░║░║░░║░░░░░░╠╩╗░╠═╣░║░║░ \n░║╚╝░╚═╝░░║░░░░░░╚═╝░║░║░╩═╝░ \n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        logo2.setEditable(false);
        logo2.setPrefSize(70,137.5);
        logo2.setFont(Font.font(3));
        logo2.setLayoutX(250);
        logo2.setLayoutY(5);

        win1 = new TextArea("Player One Wins!");
        win1.setPrefSize(501, 201);
        win1.setEditable(false);
        win1.setFont(Font.font(24));
        win1.setStyle("-fx-control-inner-background: white");
        win2 = new TextArea("Player Two Wins!");
        win2.setPrefSize(501, 201);
        win2.setEditable(false);
        win2.setFont(Font.font(24));
        win2.setStyle("-fx-control-inner-background: white");

        player1 = new Label("Player One:");
        p1d1 = new Label("D1:  --");
        p1d2 = new Label("D2:  --");
        sub1 = new Label("Sub Score:  --");
        tot1 = new Label("Total Score:  --");

        player2 =  new Label("Player Two:");
        p2d1 = new Label("D1:  --");
        p2d2 = new Label("D2:  --");
        sub2 = new Label("Sub Score:  --");
        tot2 = new Label("Total Score:  --");

        player1.setFont(Font.font(16));
        p1d1.setFont(Font.font(14));
        p1d2.setFont(Font.font(14));
        sub1.setFont(Font.font(14));
        tot1.setFont(Font.font(16));

        player2.setFont(Font.font(16));
        p2d1.setFont(Font.font(14));
        p2d2.setFont(Font.font(14));
        sub2.setFont(Font.font(14));
        tot2.setFont(Font.font(16));

        indicator = new Rectangle(500,50);
        indicator.setY(0);
        indicator.setX(0);
        indicator.setStroke(Color.LIGHTGREY);
        indicator.setFill(Color.rgb(200,200,200, .5));
        indicator.setStrokeWidth(1);

        Button play = new Button("Play");
        Button roll = new Button("Roll");
        Button pass = new Button("Pass");
        Button playAgain1 = new Button("Play Again");
        playAgain1.setLayoutX(75);
        playAgain1.setLayoutY(75);
        Button playAgain2 = new Button("Play Again");
        playAgain2.setLayoutX(75);
        playAgain2.setLayoutY(75);
        Button nightMode = new Button("N");
        nightMode.setLayoutX(475);
        nightMode.setLayoutY(150);
        Button dayMode = new Button("D");
        dayMode.setLayoutX(475);
        dayMode.setLayoutY(175);

        Label instruct = new Label("Rules                                     ");
        Label rule1 = new Label("-Click the roll button to receive 2 numbers");
        Label rule2 = new Label("-If none are a 1, then you will add their sum to your round score");
        Label rule3 = new Label("-If you roll a single 1, then you will score nothing for that round");
        Label rule4 = new Label("-If you roll snake eyes, you will lose all of your total points");
        Label rule5 = new Label("-Click pass to transfer your round score to your total score                  ");
        Label rule6 = new Label("-First to 100 Win Points Wins!");
        instruct.setFont(Font.font(24));

        FlowPane pane1 = new FlowPane(player1, p1d1, p1d2, sub1);
        pane1.setHgap(15);
        FlowPane pane2 = new FlowPane(player2, p2d1, p2d2, sub2);
        pane2.setHgap(15);
        FlowPane pane3 = new FlowPane(roll, pass);
        pane3.setHgap(35);
        FlowPane pane4 = new FlowPane(instruct,rule1,rule2,rule3,rule4,rule5,rule6);
        FlowPane pane5 = new FlowPane(nameOne, nameTwo);
        pane5.setHgap(20);

        VBox root = new VBox(pane1, tot1, pane2, tot2, pane3);
        Group root2 = new Group(indicator, root, nightMode, dayMode);
        VBox vRoot2 = new VBox(pane4, pane5, play);
        Group one = new Group(win1, playAgain1, logo1);
        Group two = new Group(win2, playAgain2, logo2);
        gameScene = new Scene(root2, 500,200);
        gameScene.setFill(Color.WHITE);
        scene1 = new Scene(one, 500,200);
        scene2 = new Scene(two,500,200);
        firstScene = new Scene(vRoot2, 500, 200);

        primaryStage.setTitle("Pig Dice");
        primaryStage.setScene(firstScene);

        roll.setOnAction(event -> rollEvent());
        pass.setOnAction(event -> passEvent(primaryStage));
        nightMode.setOnAction(event -> nightEvent(gameScene));
        dayMode.setOnAction(event -> dayEvent(gameScene));
        play.setOnAction(event -> playEvent(primaryStage));
        playAgain1.setOnAction(event -> playAgain(primaryStage));
        playAgain2.setOnAction(event -> playAgain(primaryStage));

        primaryStage.show();
    }

    private void rollEvent() {
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
                indicator.setY(55);
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
                indicator.setY(55);
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
                indicator.setY(55);
            }
        }
    }

    private void passEvent(Stage stage) {
        if (turn.isOdd()) {
            p1.pass();
            p1.setSubScore(0);
            p1d1.setText("D1:  --");
            p1d2.setText("D2:  --");
            sub1.setText("Sub Score:  --");
            tot1.setText("Total Score:  " + p1.getTotalScore());
            turn.passTurn();
            indicator.setX(0);
            indicator.setY(55);
            if (p1.getTotalScore() >= 10)
                stage.setScene(scene1);
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
            if (p2.getTotalScore() >= 10)
                stage.setScene(scene2);
        }
    }

    private void playAgain(Stage stage) {
        turn.setTurn(1);
        p1.setSubScore(0);
        p1.setTotalScore(0);
        p1d1.setText("D1:  --");
        p1d2.setText("D2:  --");
        sub1.setText("Sub Score:  --");
        tot1.setText("Total Score:  --");
        p2.setSubScore(0);
        p2.setTotalScore(0);
        p2d1.setText("D1:  --");
        p2d2.setText("D2:  --");
        sub2.setText("Sub Score:  --");
        tot2.setText("Total Score:  --");
        indicator.setX(0);
        indicator.setY(0);
        nameOne.setText("");
        nameTwo.setText("");
        stage.setScene(firstScene);
    }

   private void nightEvent(Scene scene){
        scene.setFill(Color.BLACK);
        player1.setTextFill(Color.WHITE);
        p1d1.setTextFill(Color.WHITE);
        p1d2.setTextFill(Color.WHITE);
        sub1.setTextFill(Color.WHITE);
        tot1.setTextFill(Color.WHITE);

        player2.setTextFill(Color.WHITE);
        p2d1.setTextFill(Color.WHITE);
        p2d2.setTextFill(Color.WHITE);
        sub2.setTextFill(Color.WHITE);
        tot2.setTextFill(Color.WHITE);

        win1.setStyle("-fx-control-inner-background: black");
        win2.setStyle("-fx-control-inner-background: black");

        indicator.setFill(Color.BLACK);
        indicator.setStroke(Color.WHITE);

   }


    private void dayEvent(Scene scene){
        scene.setFill(Color.WHITE);

        player1.setTextFill(Color.BLACK);
        p1d1.setTextFill(Color.BLACK);
        p1d2.setTextFill(Color.BLACK);
        sub1.setTextFill(Color.BLACK);
        tot1.setTextFill(Color.BLACK);

        player2.setTextFill(Color.BLACK);
        p2d1.setTextFill(Color.BLACK);
        p2d2.setTextFill(Color.BLACK);
        sub2.setTextFill(Color.BLACK);
        tot2.setTextFill(Color.BLACK);

        win1.setStyle("-fx-control-inner-background: white");
        win2.setStyle("-fx-control-inner-background: white");

        indicator.setFill(Color.LIGHTGREY);
        indicator.setStroke(Color.rgb(200,200,200,.5));



    }

        private void playEvent(Stage stage){
            stage.setScene(gameScene);
            if (nameOne.getText().isEmpty() || nameTwo.getText().isEmpty()){
                player1.setText("Player 1");
                player2.setText("Player 2");
            }
            else {
                player1.setText(nameOne.getText());
                player2.setText(nameTwo.getText());
            }

        }

    public static void main(String[] args) {
        launch(args);
    }
}
