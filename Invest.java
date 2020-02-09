package BlackRock;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import org.python.util.PythonInterpreter;
import org.python.core.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Invest {

    private Scene sceneInvest;

    private VBox vBox = new VBox(10);

    private ScrollPane scrollPaneInvest;

    private VBox investInfo = new VBox();
    private VBox statsInfo = new VBox();
    private VBox alertsInfo = new VBox();

    private HBox menuBar = new HBox();

    private Button investButton;
    private Button statsButton;
    private Button alertsButton;

    public Invest() {
        setUpButtons();
        setInfo();
        setUpScroll();
        setUpInvestPage();

        investButton.setOnAction(e -> fillInfo("invest"));
        //statsButton.setOnAction(e -> pythonStuff());
        statsButton.setOnAction(e -> fillInfo("stats"));
        alertsButton.setOnAction(e -> fillInfo("alerts"));

        sceneInvest = new Scene(vBox, 500,1000);
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
        investButton = new Button("Invest");
        investButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        investButton.setTextFill(Color.WHITE);
        investButton.setScaleX(2);
        investButton.setScaleY(2);

        statsButton = new Button("Stats");
        statsButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        statsButton.setTextFill(Color.WHITE);
        statsButton.setScaleX(2);
        statsButton.setScaleY(2);

        alertsButton = new Button("Alerts");
        alertsButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,
                CornerRadii.EMPTY, Insets.EMPTY)));
        alertsButton.setTextFill(Color.WHITE);
        alertsButton.setScaleX(2);
        alertsButton.setScaleY(2);

        menuBar.getChildren().addAll(investButton, statsButton, alertsButton);
        menuBar.setAlignment(Pos.BOTTOM_CENTER);
        menuBar.setTranslateX(13.5);
        menuBar.setTranslateY(23);
        menuBar.setSpacing(80);
    }

    private void setInfo(){
        setInvestInfo();
        setStatsInfo();
        setAlertsInfo();
    }

    private void setInvestInfo(){
        Button back = getBackButton();
        try{
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/3.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setFitHeight(800);
            investInfo.getChildren().addAll(back, fact1);
            investInfo.setAlignment(Pos.CENTER);
        } catch(java.io.FileNotFoundException e){
            System.out.println(e);
        }

    }

    private void setStatsInfo(){
        Button back = getBackButton();
        try{
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/stats.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setScaleX(2.5);
            fact1.setTranslateX(-20);
            statsInfo.getChildren().addAll(back, fact1);
            statsInfo.setAlignment(Pos.CENTER);
        } catch(FileNotFoundException e){
            System.out.println(e);
        }

    }

    private void setAlertsInfo(){
        Button back = getBackButton();
        try{
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/4.jpg");
            ImageView fact1 = new ImageView(new Image(input));
            fact1.setFitWidth(360);
            fact1.setFitHeight(800);
            alertsInfo.getChildren().addAll(back, fact1);
            alertsInfo.setAlignment(Pos.CENTER);
        } catch(java.io.FileNotFoundException e){
            System.out.println(e);
        }
    }

    private void setUpScroll(){
        scrollPaneInvest = new ScrollPane();
        scrollPaneInvest.setPrefSize(380, 560);
        scrollPaneInvest.setMaxWidth(380);
        scrollPaneInvest.setTranslateX(13);
        scrollPaneInvest.setContent(statsInfo);
    }

    private void setUpInvestPage(){
        try {
            FileInputStream input = new FileInputStream("/Users/rachelbick/Documents/Hackathon-BlackRockApp/src/BlackRock/latest 1.006.jpg");
            Image investBackgroundImage = new Image(input);
            BackgroundImage backgroundImage = new BackgroundImage(investBackgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            vBox.setBackground(new Background(backgroundImage));
        } catch(java.io.FileNotFoundException e) {
            System.out.println(e);
        }
        vBox.getChildren().addAll(scrollPaneInvest,menuBar);
        vBox.setAlignment(Pos.CENTER);
    }

    private void fillInfo(String page){
        if(page.equals("invest")){
            scrollPaneInvest.setContent(investInfo);
        }
        if(page.equals("stats")){
            scrollPaneInvest.setContent(statsInfo);
        }
        if(page.equals("alerts")){
            scrollPaneInvest.setContent(alertsInfo);
        }
    }

    public Scene getInvestScene(){
        return sceneInvest;
    }

    private void pythonStuff(){

        try {
            PythonInterpreter interp = new PythonInterpreter();

            interp.exec("import requests");
            interp.exec("import pandas as pd");

            interp.set("url", new PyString("https://www.blackrock.com/tools/hackathon/performance?identifiers=aapl"));
            interp.exec("response = requests.get(url)");
            interp.exec("response = response.json()");
            interp.exec("blk_security_data = response['resultMap']['RETURNS'][0]");
            interp.exec("dataman = blk_security_data['returnsMap']");
            interp.exec("df = pd.DataFrame(dataman)");
            interp.exec("print (df)");
            interp.exec("df.plot(x= 'asOfDate', y='level', kind='scatter')");

        }   catch (PyException e) {
            System.out.println(e);
        }
    }

    EventHandler<ActionEvent> handleBack() {
        return event -> {
            goBack();
        };
    }

    public void goBack(){
        PageEvent event = new PageEvent(PageEvent.LEAVE_PAGE);
        Event.fireEvent(sceneInvest, event);
    }
}
