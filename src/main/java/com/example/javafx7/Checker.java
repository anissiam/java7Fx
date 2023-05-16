package com.example.javafx7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Checker extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(20,40,20,40));
        Scene scene = new Scene(root, 400, 300);
        Label label = new Label("Check");
        label.setFont(new Font(20));
        //label.setTextFill(Color.RED);
        root.getChildren().add(label);


        TextField textField = new TextField();
        textField.setMaxWidth(300);
        textField.setFocusTraversable(false);
        textField.setPromptText("plz enter Email/URL");
        root.getChildren().add(textField);

        Button button = new Button("Check");
        root.getChildren().add(button);

        Label massage = new Label();
        root.getChildren().add(massage);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String text = textField.getText();

                if (text.isEmpty()){
                    massage.setText("Empty");
                    massage.setTextFill(Color.RED);
                    massage.setGraphic(null);
                }else if(text.contains("@")){
                    massage.setText(text + " is Email");
                    massage.setTextFill(Color.BLACK);
                    Image image = new Image(getClass().getResourceAsStream("/img/email.png"));
                    ImageView imageView = new ImageView(image);
                    massage.setGraphic(imageView);

                }else if(text.contains("https://")){
                    massage.setText(text + " is URL");
                    massage.setTextFill(Color.BLACK);

                    Image image = new Image(getClass().getResourceAsStream("/img/web.png"));
                    ImageView imageView = new ImageView(image);
                    massage.setGraphic(imageView);

                }else {
                    massage.setText(text + " is Normal text");
                    massage.setTextFill(Color.BLACK);
                    massage.setGraphic(null);
                }

            }
        });




        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }
}
