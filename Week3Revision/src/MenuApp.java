import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuApp extends Application{
    private static final String FILE_PATH = "Week3Revision/src/log.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    private final Random random = new Random();
    private final File file = new File(FILE_PATH);
    private BorderPane root;
    private TextField textField;
    private Label messageLabel;

    @Override
    public void start(Stage primaryStage){
        initializeControls();
        MenuBar menuBar = createMenuBar(primaryStage);
        root.setTop(menuBar);
        root.setCenter(textField);
        root.setBottom(messageLabel);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeControls(){
        root = new BorderPane();
        textField = new TextField();
        messageLabel = new Label("");
    }

    private MenuBar createMenuBar(Stage primaryStage){
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem dateTimeItem = new MenuItem("Date & Time");
        MenuItem writeFileItem = new MenuItem("Write to file");
        MenuItem changeGreenHue = new MenuItem("Change background color");
        MenuItem exitItem = new MenuItem("Exit");

        // action items
        dateTimeItem.setOnAction(e -> showDateTime());
        writeFileItem.setOnAction(e -> writeToFile());
        changeGreenHue.setOnAction(e -> changeBackgroundColor());
        exitItem.setOnAction(e -> primaryStage.close());

        // load menu and menu items
        fileMenu.getItems().addAll(dateTimeItem, writeFileItem, changeGreenHue, exitItem);
        menuBar.getMenus().add(fileMenu);
        return menuBar;
    }

    private void showDateTime(){
        String currentDateTime = LocalDateTime.now().format(DATE_FORMAT);
        textField.setText(currentDateTime);
        messageLabel.setText("Date and time displayed.");
    }

    private void writeToFile(){
        String text = textField.getText().trim();

        if(text.isEmpty()){
            messageLabel.setText("Text field is empty.");
            return;
        }

        // create a parent directory if needed
        createParentDirectoryIfNeeded();
        boolean append = file.exists() && file.length() > 0;

        try (FileWriter writer = new FileWriter(file, append)){
            if(append){
                writer.write(System.lineSeparator());
            }
            writer.write(text);
            messageLabel.setText(append ? "File saved successfully." : "File created successfully.");
        }catch (IOException e){
            messageLabel.setText("Error writing to file.");
        }
    }

    private void createParentDirectoryIfNeeded(){
        File parent = file.getParentFile();
        if(parent != null && !parent.exists()){
            parent.mkdirs();
        }
    }

    private void changeBackgroundColor(){
        double greenHue = 100 + random.nextDouble() * 40;
        Color greenColor = Color.hsb(greenHue, 0.8, 0.8);
        String hexColor = toHexColor(greenColor);
        root.setStyle("-fx-background-color: " + hexColor + ";");
        messageLabel.setText("Background color change to " + hexColor);
    }

    private String toHexColor(Color color){
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args){
        launch(args);
    }


}
