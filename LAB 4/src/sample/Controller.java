package sample;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    private Boolean statePoint = true;
    private Boolean musicState = true;
    private ObservableList item = FXCollections.observableArrayList();
    private String alarm = "song2.mp3";
    private Media sound;
    private MediaPlayer mediaPlayer;
    private ObservableList items = FXCollections.observableArrayList();


    @FXML
    private ListView<String> timeList;

    @FXML
    private Canvas canvas;
    
    @FXML
    void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawHour(gc);

        Timeline timelinedrawHour = new Timeline(new KeyFrame(Duration.millis(10), ae -> drawHour(gc)));
        timelinedrawHour.setCycleCount(Animation.INDEFINITE);
        timelinedrawHour.play();

        Timeline timelineanimation = new Timeline(new KeyFrame(Duration.seconds(1), ae -> animation()));
        timelineanimation.setCycleCount(Animation.INDEFINITE);
        timelineanimation.play();

        Timeline timelineMusic = new Timeline(new KeyFrame(Duration.minutes(1), ae -> setStateMusic()));
        timelineMusic.setCycleCount(Animation.INDEFINITE);
        timelineMusic.play();
    }

    private void drawHour(GraphicsContext gc) {
        DateFormat dateFormat1 = new SimpleDateFormat("HH");
        DateFormat dateFormat2 = new SimpleDateFormat("mm");
        DateFormat dateFormat3 = new SimpleDateFormat("ss");
        Date date = new Date();

        String msg = dateFormat1.format(date);
        if(statePoint)
            msg += ":";
        else
            msg += " ";
        msg+=dateFormat2.format(date);

        String msg2 = dateFormat3.format(date);

        Text text = new Text(msg);
        Text text2 = new Text(msg2);
        Font font = Font.loadFont("file:resources/fonts/DigitaldreamSkewNarrow.ttf", 70);
        Font font2 = Font.loadFont("file:resources/fonts/DigitaldreamSkewNarrow.ttf", 50);
        text.setFont(font);
        text2.setFont(font2);

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFont(font);
        gc.fillText(msg,canvas.getWidth()/2 - text.getLayoutBounds().getWidth()/2, canvas.getHeight()/2 + text.getLayoutBounds().getHeight()/2);
        gc.setFont(font2);
        gc.fillText(msg2,canvas.getWidth()/2 + text.getLayoutBounds().getWidth()/2, canvas.getHeight()/2 + text.getLayoutBounds().getHeight()/2-text2.getLayoutBounds().getHeight()/2);
    }

    private void animation()
    {
        if(statePoint)
            statePoint = false;
        else
            statePoint = true;

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        String msg = dateFormat.format(date);

        if(item.contains(msg) && musicState)
            playmusic();

    }

    private void setStateMusic()
    {
        musicState = true;
    }

    private void playmusic()
    {
        sound = new Media(new File(alarm).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        musicState = false;
    }

    public void about(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("O autorze.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("O AUTORZE");
        primaryStage.setScene(new Scene(root, 633, 400));
        primaryStage.show();
    }

    public void setAlarm(ActionEvent event)
    {
        items.add("12:04");
        timeList.setItems(items.sorted());
        //items.add("21:05");
        //timeList.setItems(items.sorted());
    }



    public void deleteAlarm(ActionEvent actionEvent) {
        if(timeList.getSelectionModel().getSelectedIndex() >= 0)
            items.remove(timeList.getSelectionModel().getSelectedIndex());
    }



    public void closeWindow(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void addAlarmWindow(ActionEvent actionEvent) throws IOException {


        Stage meaStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("Dodaj budzik.fxml"));
        AnchorPane meaPane = loader.load();
        Scene meaScene = new Scene(meaPane);
        meaStage.setScene(meaScene);
        meaStage.setTitle("Dodaj alarm");
        meaStage.show();


    }

    public void clearAllAlarms(ActionEvent actionEvent) {
    }
}
