package BlackRock;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Learn {

    private Scene sceneLearn;

    private VBox vBox = new VBox(10);

    private ScrollPane scrollPaneLearn;

    private VBox unlockInfo = new VBox();
    private VBox keepUpInfo = new VBox();
    private VBox discoverInfo = new VBox();
    VBox quizInfo = new VBox();

    private HBox menuBar = new HBox();

    private Button unlockButton;
    private Button keepUpButton;
    private Button discoverButton;
    private Button quizButton;

    public Learn() {
        setUpButtons();
        setInfo();
        setUpScroll();
        setUpLearnPage();

        unlockButton.setOnAction(e -> fillInfo("unlock"));
        keepUpButton.setOnAction(e -> fillInfo("keep up"));
        discoverButton.setOnAction(e -> fillInfo("discover"));
        quizButton.setOnAction(e -> fillInfo("take quiz"));


        sceneLearn = new Scene(vBox, 500,1000);
        vBox.requestFocus();
    }

    private void setUpButtons(){

        unlockButton = new Button(" Unlock ");
        unlockButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        unlockButton.setTextFill(Color.WHITE);
        unlockButton.setScaleX(1.6);
        unlockButton.setScaleY(1.9);

        quizButton = new Button("Test your self!");
        unlockButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        unlockButton.setTextFill(Color.WHITE);
        unlockButton.setScaleX(1.6);
        unlockButton.setScaleY(1.9);

        keepUpButton = new Button("Keep Up");
        keepUpButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        keepUpButton.setTextFill(Color.WHITE);
        keepUpButton.setScaleX(1.6);
        keepUpButton.setScaleY(1.9);

        discoverButton = new Button("Discover");
        discoverButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        discoverButton.setTextFill(Color.WHITE);
        discoverButton.setScaleX(1.6);
        discoverButton.setScaleY(1.9);

        menuBar.getChildren().addAll(unlockButton, keepUpButton, discoverButton);
        menuBar.setAlignment(Pos.BOTTOM_CENTER);
        menuBar.setTranslateX(17);
        menuBar.setTranslateY(23);
        menuBar.setSpacing(61);
    }

    private void setInfo(){
        setUnlockInfo();
        setKeepUpInfo();
        setDiscoverInfo();
        setQuizInfo();
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

    private void setUnlockInfo(){
        Label label = new Label("Unlock");
        label.setFont(new Font(60));
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        label.setTextFill(Color.BLACK);
        Button back = getBackButton();
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/learn thing.009.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setScaleX(3.5);
            fact1.setTranslateX(32);
            unlockInfo.getChildren().addAll(back, label, fact1, quizButton);
            unlockInfo.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setQuizInfo(){
        Button back = getBackButton();
        ImageView q1= null;
        ImageView q2= null;
        ImageView q3= null;
        ImageView q4= null;
        ImageView q5= null;
        ImageView q6= null;
        ImageView q7= null;
        ImageView q8= null;
        ImageView q9= null;
        ImageView q10= null;
        try {
            FileInputStream i1 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question1.png");
            q1 = new ImageView(new Image(i1));
            q1.setFitWidth(250);
            q1.setFitHeight(200);
            FileInputStream i2 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question2.png");
            q2 = new ImageView(new Image(i2));
            q2.setFitWidth(250);
            q2.setFitHeight(200);
            FileInputStream i3 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question3.png");
            q3 = new ImageView(new Image(i3));
            q3.setFitWidth(250);
            q3.setFitHeight(200);
            FileInputStream i4 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question4.png");
            q4 = new ImageView(new Image(i4));
            q4.setFitWidth(250);
            q4.setFitHeight(200);
            FileInputStream i5 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question5.png");
            q5 = new ImageView(new Image(i5));
            q5.setFitWidth(250);
            q5.setFitHeight(200);
            FileInputStream i6 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question6.png");
            q6 = new ImageView(new Image(i6));
            q6.setFitWidth(250);
            q6.setFitHeight(200);
            FileInputStream i7 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question7.png");
            q7 = new ImageView(new Image(i7));
            q7.setFitWidth(250);
            q7.setFitHeight(200);
            FileInputStream i8 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question8.png");
            q8 = new ImageView(new Image(i8));
            q8.setFitWidth(250);
            q8.setFitHeight(200);
            FileInputStream i9 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question9.png");
            q9 = new ImageView(new Image(i9));
            q9.setFitWidth(250);
            q9.setFitHeight(200);
            FileInputStream i10 = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/questions/question10.png");
            q10 = new ImageView(new Image(i10));
            q10.setFitWidth(250);
            q10.setFitHeight(200);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        HBox h1 = new HBox();
        h1.getChildren().addAll(q1, getTrueBar());
        h1.setSpacing(30);
        HBox h2 = new HBox();
        h2.getChildren().addAll(q2, getFalseBar());
        h2.setSpacing(30);
        HBox h3 = new HBox();
        h3.getChildren().addAll(q3, getTrueBar());
        h3.setSpacing(30);
        HBox h4 = new HBox();
        h4.getChildren().addAll(q4, getTrueBar());
        h4.setSpacing(30);
        HBox h5 = new HBox();
        h5.getChildren().addAll(q5, getFalseBar());
        h5.setSpacing(30);
        HBox h6 = new HBox();
        h6.getChildren().addAll(q6, getFalseBar());
        h6.setSpacing(30);
        HBox h7 = new HBox();
        h7.getChildren().addAll(q7, getFalseBar());
        h7.setSpacing(30);
        HBox h8 = new HBox();
        h8.getChildren().addAll(q8, getTrueBar());
        h8.setSpacing(30);
        HBox h9 = new HBox();
        h9.getChildren().addAll(q9, getTrueBar());
        h9.setSpacing(30);
        HBox h10 = new HBox();
        h10.getChildren().addAll(q10, getTrueBar());
        h10.setSpacing(30);

        quizInfo.getChildren().addAll(back, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10);
    quizInfo.setSpacing(20);
    }

    private void setKeepUpInfo(){
        Button back = getBackButton();
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/1.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setFitHeight(800);
            keepUpInfo.getChildren().addAll(back, fact1);
            keepUpInfo.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void setDiscoverInfo(){
        Button back = getBackButton();
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/discover.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setScaleX(3);
            discoverInfo.getChildren().addAll(back, fact1);
            discoverInfo.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private VBox getTrueBar(){
        VBox vBox = new VBox();
        Button t =  new Button("True");
        t.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        t.setBorder(new Border(new BorderStroke(Color.LIGHTSKYBLUE, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Button f = new Button("False");
        f.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        f.setBorder(new Border(new BorderStroke(Color.LIGHTSKYBLUE, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        t.setOnAction(e -> rightAnswer(t));
        vBox.getChildren().addAll(t,f);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        return vBox;
    }

    private VBox getFalseBar(){
        VBox vBox = new VBox();
        Button t =  new Button("True");
        t.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        t.setBorder(new Border(new BorderStroke(Color.LIGHTSKYBLUE, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Button f = new Button("False");
        f.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        f.setBorder(new Border(new BorderStroke(Color.LIGHTSKYBLUE, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        f.setOnAction(e -> rightAnswer(f));
        vBox.getChildren().addAll(t,f);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        return vBox;
    }

    private void rightAnswer(Button b){
        b.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void setUpScroll(){
        scrollPaneLearn = new ScrollPane();
        scrollPaneLearn.setPrefSize(380, 560);
        scrollPaneLearn.setMaxWidth(380);
        scrollPaneLearn.setTranslateX(13);
        scrollPaneLearn.setContent(keepUpInfo);
    }

    private void setUpLearnPage(){
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/latest 1.004.jpg");
            Image learnBackgroundImage = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(learnBackgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            vBox.setBackground(new Background(backgroundImage));
        } catch(java.io.FileNotFoundException e) {
            System.out.println(e);
        }
        vBox.getChildren().addAll(scrollPaneLearn,menuBar);
        vBox.setAlignment(Pos.CENTER);
    }

    private void fillInfo(String page){
        if(page.equals("unlock")){
            scrollPaneLearn.setContent(unlockInfo);
        }
        if(page.equals("keep up")){
            scrollPaneLearn.setContent(keepUpInfo);
        }
        if(page.equals("discover")){
            scrollPaneLearn.setContent(discoverInfo);
        }
        if(page.equals("take quiz")){
            scrollPaneLearn.setContent(quizInfo);
        }
    }

    public Scene getLearnScene(){
        return sceneLearn;
    }

    EventHandler<ActionEvent> handleBack() {
        return event -> {
            goBack();
        };
    }

    public void goBack(){
        PageEvent event = new PageEvent(PageEvent.LEAVE_PAGE);
        Event.fireEvent(sceneLearn, event);
    }

}
