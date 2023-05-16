package com.example.javafx7;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUp extends Application {
    private String gender;
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root , 400 , 500);

        Text text = new Text("SignUp");
        text.setFont(new Font("Jamrul",20));
        root.getChildren().add(text);

        TextField textEmail = new TextField();
        textEmail.setFocusTraversable(false);
        textEmail.setPromptText("Plz enter Email");
        root.getChildren().add(textEmail);

        PasswordField passwordField = new PasswordField();
        passwordField.setFocusTraversable(false);
        passwordField.setPromptText("Plz enter Password");
        root.getChildren().add(passwordField);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        root.getChildren().add(hBox);

        Text text1 = new Text("Gender");
        hBox.getChildren().add(text1);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radioButtonFemale = new RadioButton("Female");
        radioButtonFemale.setToggleGroup(toggleGroup);
        hBox.getChildren().add(radioButtonFemale);

        RadioButton radioButtonMale = new RadioButton("Male");
        radioButtonMale.setToggleGroup(toggleGroup);
        hBox.getChildren().add(radioButtonMale);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {
                RadioButton radioButton =(RadioButton) t1.getToggleGroup().getSelectedToggle();
                gender = radioButton.getText();
                System.out.println(gender);
            }
        });


        CheckBox checkBox = new CheckBox();
        checkBox.setIndeterminate(true);
        checkBox.setText("Agree the role");
        root.getChildren().add(checkBox);

        Button button = new Button("SignUp");
        root.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email = textEmail.getText();
                String password = passwordField.getText();
                if (email.isEmpty()){
                    System.out.println("Plz enter email");
                    return;
                }

                if (password.isEmpty()){
                    System.out.println("Plz enter Password");
                    return;
                }

                if (gender==null){
                    System.out.println("Plz select gender");
                    return;
                }
                boolean checked = checkBox.isSelected();
                if (!checked){
                   System.out.println("Plz agree the role");
                   return;
                }

                System.out.println("Success");


            }
        });


        stage.setScene(scene);
        stage.show();
    }
}
