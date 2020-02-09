package BlackRock;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.io.FileInputStream;

public class BlackRockApp extends Application{

    private Stage window;

    private boolean welcomeHasBeenViewed = false;

    private Scene sceneChoose;

    private Scene scenePage;

    private VBox layout = new VBox(100);

    private Button buttonLearn = new Button("Learn");

    private Button buttonTrain = new Button("Train");

    private Button buttonInvest = new Button("Invest");

    @Override
    public void start(Stage stage) throws Exception {

        window = stage;
        window.setHeight(1000);
        window.setWidth(500);

        setButtonsAndLabels();

        layout = getLayout();

        layout.getChildren().addAll(buttonLearn, buttonTrain, buttonInvest);
        layout.setSpacing(200);

        sceneChoose = new Scene(layout, 381, 700);

        buttonLearn.setOnAction(e -> startPage("Learn"));
        buttonTrain.setOnAction(e -> startPage("Train"));
        buttonInvest.setOnAction(e -> startPage("Invest"));

        if(!welcomeHasBeenViewed) {
            Scene sceneWelcome = new Scene(getWelcomeePage(), 381, 700);
            window.setScene(sceneWelcome);
            welcomeHasBeenViewed = true;
        } else {
            window.setScene(sceneChoose);
        }
        window.setResizable(false);
        window.show();

    }

    private void setButtonsAndLabels(){
        buttonLearn.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        buttonLearn.setTextFill(Color.BLACK);
        buttonLearn.setScaleX(6);
        buttonLearn.setScaleY(6);
        buttonLearn.setTranslateX(15);
        buttonLearn.setFont(Font.font("Avenir", FontWeight.BOLD, 20));

        buttonTrain.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        buttonTrain.setTextFill(Color.BLACK);
        buttonTrain.setScaleX(6);
        buttonTrain.setScaleY(6);
        buttonTrain.setTranslateX(15);
        buttonTrain.setFont(Font.font("Avenir", FontWeight.BOLD, 20));

        buttonInvest.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        buttonInvest.setTextFill(Color.BLACK);
        buttonInvest.setScaleX(6);
        buttonInvest.setScaleY(6);
        buttonInvest.setTranslateX(15);
        buttonInvest.setFont(Font.font("Avenir", FontWeight.BOLD, 20));
    }

    private VBox getWelcomeePage(){
        VBox welcome = new VBox();
        Button onward = new Button("");
        onward.setPrefSize(400,800);
        onward.setOnAction(e -> startPage("choose"));
        onward.setAlignment(Pos.CENTER);
        onward.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        try{
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/br_pages3.001.jpg");
            Image menuBackgroundImage = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(menuBackgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            welcome.setBackground(new Background(backgroundImage));
        }catch(java.io.FileNotFoundException e){
            System.out.println(e);
        }
        welcome.getChildren().add(onward);
        return welcome;
    }

    private VBox getLayout(){
        try{
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/latest 1.002.jpg");
            Image menuBackgroundImage = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(menuBackgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            layout.setBackground(new Background(backgroundImage));
            layout.setAlignment(Pos.CENTER);
            layout.setSpacing(0.0);
        }catch (java.io.FileNotFoundException e){
            System.out.println(e);
            System.out.println("problem accessing image");
            System.exit(1);
        }
        return layout;
    }

    EventHandler<PageEvent> pageEvent = event -> {
        leavePage();
    };

    private void leavePage(){
        scenePage.removeEventHandler(PageEvent.LEAVE_PAGE, pageEvent);
        scenePage = null;
        window.setScene(sceneChoose);
    }

    private void startPage(String page){
        if(page.equals("choose")){
            scenePage = sceneChoose;
        }
        else if(page.equals("Learn")){
            window.setTitle("Learn");
            Learn learn = new Learn();
            scenePage = learn.getLearnScene();
        }
        else if(page.equals("Train")){
            window.setTitle("Train");
            Train train = new Train();
            scenePage = train.getTrainScene();
        }
        else if(page.equals("Invest")){
            window.setTitle("Invest");
            Invest invest = new Invest();
            scenePage = invest.getInvestScene();
        }

        scenePage.addEventHandler(PageEvent.LEAVE_PAGE, pageEvent);
        window.setScene(scenePage);
    }

}
