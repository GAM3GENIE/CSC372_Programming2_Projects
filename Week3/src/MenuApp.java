import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;



public class MenuApp extends Application {

    @Override
    public void start(Stage primaryStage){
        TextField textField = new TextField();
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        File file = new File("Week3/src/log.txt");
        Label messageLabel = new Label("");
        VBox layout = new VBox(10);

        // Menu and menu items
        Menu fileMenu = new Menu("File");
        MenuItem firstItem = new MenuItem("Date & Time");
        MenuItem secondItem = new MenuItem("Write to file");
        MenuItem thirdItem = new MenuItem("Change background color");
        MenuItem fourthItem = new MenuItem("Exit");
        Random randomColor = new Random();

        // action events for all menu items
        firstItem.setOnAction(actionEvent ->{
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            textField.setText(now.format(formatter));
            messageLabel.setText("Date and Time");
        });

        secondItem.setOnAction(actionEvent -> {
            if(file.exists() && file.length() > 0) {
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write("\n" + textField.getText());
                    messageLabel.setText("File saved successfully.");
                } catch (IOException e) {
                    messageLabel.setText("Error in writing to file");
                }
            }else{
                try (FileWriter writer = new FileWriter(file)){
                    writer.write(textField.getText());
                    messageLabel.setText("File created successfully.");
                } catch (IOException e) {
                    messageLabel.setText("Error creating file.");
                }
            }
        });

        thirdItem.setOnAction(actionEvent -> {
            double greenHue = 100 + randomColor.nextDouble() * 40;
            Color greenColor = Color.hsb(greenHue, 0.8, 0.8);

            String hexColors = String.format("#%02X%02X%02X",
                    (int) (greenColor.getRed() * 255),
                    (int) (greenColor.getGreen() * 255),
                    (int) (greenColor.getBlue() * 255));
            root.setStyle("-fx-background-color: " + hexColors + ";");
            messageLabel.setText(hexColors);
        });

        fourthItem.setOnAction(actionEvent -> {
            primaryStage.close();
        });

        // adding items to application
        layout.getChildren().addAll(menuBar, textField, messageLabel);
        menuBar.getMenus().add(fileMenu);
        fileMenu.getItems().addAll(firstItem, secondItem, thirdItem, fourthItem);
        root.setTop(menuBar);
        root.setCenter(textField);
        root.setBottom(messageLabel);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
