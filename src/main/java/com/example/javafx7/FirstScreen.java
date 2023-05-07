package com.example.javafx7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstScreen extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start");
        Group root = new Group();
        Text text = new Text("Hello from java ");
        text.setFill(Color.RED);
        Font font = new Font(20);
        text.setFont(font);
        text.setX(100);
        text.setY(75);
        root.getChildren().add(text);

        Line line = new Line();
        line.setStartX(50);
        line.setStartY(200);
        line.setEndX(200);
        line.setEndY(200);
        line.setRotate(30);
        line.setFill(Color.GREEN);
        line.setStroke(Color.VIOLET);
        line.setStrokeWidth(10);
        root.getChildren().add(line);

        Scene scene = new Scene(root , 500,500);
        scene.setFill(Color.CYAN);

        stage.setScene(scene);
        stage.setTitle("First Screen");
        //stage.setResizable(false);
        //stage.setFullScreen(true);
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }
}
