package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;



public class TaxTipAndTotal extends Application {

    @Override
    public void start(Stage primaryStage) {
        final double totalTip = .21;
        final double salesTax = .09;

        Label mealCharge = new Label("Meal Charge: ");
        TextField mealChargeTextField = new TextField("0");
        HBox mealChargeHBox = new HBox(10, mealCharge, mealChargeTextField);
        mealChargeHBox.setAlignment(Pos.CENTER_LEFT);

        Label tip = new Label ("Tip: ");
        Label tipOutputLabel = new Label();
        HBox tipHBox = new HBox(10,tip, tipOutputLabel);
        tipHBox.setAlignment(Pos.CENTER_LEFT);

        Label tax = new Label("Tax: ");
        Label taxOutputLabel = new Label();
        HBox taxHBox = new HBox(10,tax, taxOutputLabel);
        taxHBox.setAlignment(Pos.CENTER_LEFT);

        Label total = new Label("Total: ");
        Label totalOutputLabel = new Label();
        HBox totalHBox = new HBox(10, total, totalOutputLabel);
        totalHBox.setAlignment(Pos.CENTER_LEFT);

        Button calculate = new Button("Calculate");
        calculate.setAlignment(Pos.CENTER);

        calculate.setOnAction(e->{
            double percentTip = totalTip * Double.parseDouble(mealChargeTextField.getText());
            double totalTax = salesTax * Double.parseDouble(mealChargeTextField.getText());
            double totalAmount = percentTip + totalTax + Double.parseDouble(mealChargeTextField.getText());

            tipOutputLabel.setText(String.format("%.2f", percentTip));
            taxOutputLabel.setText(String.format("%.2f", totalTax));
            totalOutputLabel.setText(String.format("%.2f", totalAmount));

        });

        VBox mainVBox = new VBox(10,mealChargeHBox, tipHBox, taxHBox, totalHBox, calculate);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPadding(new Insets(10));

        Scene scene = new Scene(mainVBox);

        primaryStage.setScene(scene);
        primaryStage.show();




    }

    public static void main(String[] args) {
        launch(args);
    }


}
