package datastructurecw;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    // DISPLAYS AN ALERT BOX NEED TO RECEIVE 3 STRINGS TITLE, THE MSG, AND THE
    //BTN MSG
    public void display(String title, String message, String btnMessage) {
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setMinWidth(600);
        Label lbl = new Label();
        lbl.setText(message);
        lbl.setFont(Font.font("Verdana", 20));
        lbl.getStyleClass().add("Abox");
        Button closeBtn = new Button();
        closeBtn.setMinSize(35, 30);
        closeBtn.setText(btnMessage);
        closeBtn.getStyleClass().add("box-1");
        closeBtn.setOnAction(e -> primaryStage.close());
        VBox layout = new VBox(20);
        layout.getChildren().addAll(lbl, closeBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("Css.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

}
