package sample;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import java.util.Random;
import java.util.ArrayList;


public class HeadsOrTails extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
            Image heads = new Image("Heads.png");
            Image tails = new Image("Tails.png");

            ArrayList<Image> imageList = new ArrayList<>();

            imageList.add(heads);
            imageList.add(tails);

            ImageView tailsIV = new ImageView();
            ImageView headsIV = new ImageView();

            tailsIV.setFitHeight(100);
            tailsIV.setFitWidth(100);
            headsIV.setFitWidth(100);
            headsIV.setFitHeight(100);

            HBox imageHBox = new HBox(10, tailsIV, headsIV);

            Button button = new Button("Toss");

            button.setOnAction(e->{
                Random randy = new Random(1);


                if(randy.nextInt() == 1)
                    tailsIV.setImage(imageList.get(randy.nextInt(imageList.size())));
                else
                    headsIV.setImage(imageList.get(randy.nextInt(imageList.size())));


            });
            VBox imageVBox = new VBox(10, imageHBox, button);
            imageVBox.setAlignment(Pos.CENTER);
            imageVBox.setPadding(new Insets(10));

            Scene scene = new Scene(imageVBox);

            primaryStage.setScene(scene);
            primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
