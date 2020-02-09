package BlackRock;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.plaf.MenuBarUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Train {

    private Scene sceneTrain;

    private VBox vBox = new VBox(10);

    private ScrollPane scrollPaneTrain;

    private VBox playInfo = new VBox();
    private VBox profileInfo = new VBox();
    private VBox connectInfo = new VBox();

    private HBox menuBar = new HBox();

    private Button playButton;
    private Button profileButton;
    private Button connectButton;

    public Train() {
        setUpButtons();
        setInfo();
        setUpScroll();
        setUpTrainPage();

        playButton.setOnAction(e -> fillInfo("play"));
        profileButton.setOnAction(e -> fillInfo("profile"));
        connectButton.setOnAction(e -> fillInfo("connect"));

        sceneTrain = new Scene(vBox, 500,1000);
        vBox.requestFocus();
    }

    private Button getBackButton(){
        Button back = new Button("Go Back");
        back.setFocusTraversable(false);
        back.setOnAction(handleBack());
        back.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        back.setTranslateX(140);
        back.setTextFill(Color.GRAY);
        return back;
    }

    private void setUpButtons(){
        playButton = new Button("  Play  ");
        playButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        playButton.setTextFill(Color.WHITE);
        playButton.setScaleX(1.9);
        playButton.setScaleY(1.9);

        profileButton = new Button("Profile");
        profileButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        profileButton.setTextFill(Color.WHITE);
        profileButton.setScaleX(1.9);
        profileButton.setScaleY(1.9);

        connectButton = new Button("Connect");
        connectButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        connectButton.setTextFill(Color.WHITE);
        connectButton.setScaleX(1.9);
        connectButton.setScaleY(1.9);

        menuBar.getChildren().addAll(playButton, profileButton, connectButton);
        menuBar.setAlignment(Pos.BOTTOM_CENTER);
        menuBar.setTranslateX(17);
        menuBar.setTranslateY(23);
        menuBar.setSpacing(70);
    }

    private void setInfo(){
        setPlayInfo();
        setProfileInfo();
        setConnectInfo();
    }

    private void setPlayInfo(){
        Button back = getBackButton();
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/play.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setFitHeight(800);
            playInfo.getChildren().addAll(back, fact1);
            playInfo.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void setProfileInfo(){
        Button back = getBackButton();
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/profile page update.009.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setScaleX(2.5);
            fact1.setTranslateX(-10);
            profileInfo.getChildren().addAll(back, fact1);
            profileInfo.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setConnectInfo(){
        Button back = getBackButton();
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/2.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setFitHeight(800);
            connectInfo.getChildren().addAll(back, fact1);
            connectInfo.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void setUpScroll(){
        scrollPaneTrain = new ScrollPane();
        scrollPaneTrain.setPrefSize(380, 560);
        scrollPaneTrain.setMaxWidth(380);
        scrollPaneTrain.setTranslateX(13);
        scrollPaneTrain.setContent(profileInfo);
    }

    private void setUpTrainPage(){
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/latest 1.005.jpg");
            Image trainBackgroundImage = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(trainBackgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            vBox.setBackground(new Background(backgroundImage));
        } catch(java.io.FileNotFoundException e) {
            System.out.println(e);
        }
        vBox.getChildren().addAll(scrollPaneTrain,menuBar);
        vBox.setAlignment(Pos.CENTER);
    }

    private void fillInfo(String page){
        if(page.equals("play")){
            scrollPaneTrain.setContent(playInfo);
        }
        if(page.equals("profile")){
            scrollPaneTrain.setContent(profileInfo);
        }
        if(page.equals("connect")){
            scrollPaneTrain.setContent(connectInfo);
        }
    }

    public Scene getTrainScene(){
        return sceneTrain;
    }

    EventHandler<ActionEvent> handleBack() {
        return event -> {
            goBack();
        };
    }

    public void goBack(){
        PageEvent event = new PageEvent(PageEvent.LEAVE_PAGE);
        Event.fireEvent(sceneTrain, event);
    }
}
