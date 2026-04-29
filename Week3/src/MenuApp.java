import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MenuApp extends Application {

    public static void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        TextField textField = new TextField();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

        MenuItem firstItem = new MenuItem("Date & Time");
        MenuItem secondItem = new MenuItem("Write to file");
        MenuItem thirdItem = new MenuItem("Change background color");
        MenuItem fourthItem = new MenuItem("Exit");

        firstItem.setOnAction(actionEvent ->{
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            textField.setText(now.format(formatter));
        });

        File file = new File("log.txt");

        secondItem.setOnAction(actionEvent -> {
            if(file.exists() && file.length() > 0) {
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write("\n" + textField.getText());
                } catch (IOException e) {
                    textField.setText("Error in writing to file");
                }
            }else{
                try (FileWriter writer = new FileWriter(file)){
                    writer.write(textField.getText());
                } catch (IOException e) {
                    textField.setText("Error creating file.");
                }
            }
        });

        fourthItem.setOnAction(actionEvent -> {
            primaryStage.close();
        });

        menuBar.getMenus().add(fileMenu);
        fileMenu.getItems().addAll(firstItem, secondItem, thirdItem, fourthItem);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(textField);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
