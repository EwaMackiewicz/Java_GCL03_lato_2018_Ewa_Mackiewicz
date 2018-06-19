package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller3 {
    @FXML
    private ImageView imageAvatar;

    @FXML
    void initialize() throws FileNotFoundException
    {
        //Image image = new Image(new FileInputStream("default-avatar-women.png"));
        //imageAvatar.setImage(image);
    }
}
