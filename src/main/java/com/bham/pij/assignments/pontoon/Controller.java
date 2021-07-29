package com.bham.pij.assignments.pontoon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML private Button play;
    @FXML private TextField BET;
    @FXML private TextField Save;
    @FXML private TextField playerName1;
    @FXML private TextField playerName;
    @FXML private ChoiceBox choiceBox;
    @FXML private TextField noofplayers;
    @FXML private ImageView imageView0;
    @FXML private ImageView imageView1;
    @FXML private ImageView imageView2;
    @FXML private ImageView imageView3;
    @FXML private ImageView computerIcon;
    @FXML private ImageView playerIcon;
    @FXML private Button hit;


    ObservableList<Integer> list = FXCollections.observableArrayList(1,2);

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        choiceBox.setItems(list);
        noofplayers.setText("Number of players ");

    }

    // number of players sets the number of players for the pontoon constructor
    public int setNoOfPlayers(ActionEvent event)
    {
        int playerNum = 2;
        return playerNum;
    }

    public void startAGame(ActionEvent event)
    {
        //TODO need to move this to its own method
        Image backOfCardImage = new Image("back_of_card.png");
        imageView0.setImage(backOfCardImage);
        imageView1.setImage(backOfCardImage);
        imageView2.setImage(backOfCardImage);
        imageView3.setImage(backOfCardImage);

        ArrayList<String> player1String = new ArrayList<>();
        ArrayList<String> player2String = new ArrayList<>();


        Button startGame = ((Button)event.getSource());

        if(startGame.isArmed())
        {
            int playerNum = setNoOfPlayers(event);
            Pontoon pontoon = new Pontoon(playerNum);
            pontoon.dealInitialCards();
            //this logic doesn't work cause it is not the same set of cards you
            //ypu need to intergrate the image compnent into the original game logic
            player1String = pontoon.getCardImageValuePlayer1(pontoon.namesListOfPlayer.get(0));
            for(String s : player1String)
            {
               Image faceOfCardImage = new Image("./cards/"+s.toLowerCase());
               imageView0.setImage(faceOfCardImage);
            }
            player2String = pontoon.getCardImageValuePlayer1(pontoon.namesListOfPlayer.get(1));
            Image faceOfCardImage = new Image("./cards/"+player2String.get(0).toLowerCase());
            imageView2.setImage(faceOfCardImage);
        }

        if(hit.isArmed())
        {
            Image faceOfCardImage2 = new Image("./cards/" + player1String.get(1).toLowerCase());
            imageView1.setImage(faceOfCardImage2);

            Image faceOfCardImage3 = new Image("./cards/" + player2String.get(1).toLowerCase());
            imageView3.setImage(faceOfCardImage3);
        }
    }

    public void setPlayerName(ActionEvent event)
    {
        Image computerIconImage = new Image("computericon.png");
        Image playerIconImage = new Image("usericon.png");

         Button playerString = ((Button)event.getSource());
         if(playerString.isPressed())
         {
         }

         if(choiceBox.getValue().toString().equals("1"))
         {
             String playerNo = Save.getText();
             playerName.setText(playerNo);
            Save.disabledProperty();
            Save.clear();
            playerName1.setText("Computer");
            computerIcon.setImage(computerIconImage);
            playerIcon.setImage(playerIconImage);
         }
         if(choiceBox.getValue().toString().equals("2"))
         {
             if(playerName.getText().isEmpty()){
             String playerN = Save.getText();
             playerName.setText(playerN);
             Save.clear();}
             Save.setPromptText("Enter next name");
             String playerNo = Save.getText();
             playerName1.setText(playerNo);
             Save.clear();
             Save.disabledProperty();
             playerIcon.setImage(playerIconImage);
             computerIcon.setImage(playerIconImage);
         }

    }





}
