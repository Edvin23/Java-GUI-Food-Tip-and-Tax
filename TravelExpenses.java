package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


public class TravelExpenses extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final double meals = 38.00;
        final double parkingFees = 25.00;
        final double taxiPerDay = 49.00;
        final double lodgingPerDay = 215.00;
        final double perMile = 0.49;

        Label daysOnTrip = new Label("Days on the trip: ");
        TextField daysOnTripTextField = new TextField("0");
        HBox daysOnTripHBox = new HBox(10, daysOnTrip, daysOnTripTextField);
        daysOnTripHBox.setAlignment(Pos.CENTER);

        Label airFare = new Label("Airfare: ");
        TextField airfareTextField = new TextField("0");
        HBox airfareHBox = new HBox(10,airFare,airfareTextField);
        airfareHBox.setAlignment(Pos.CENTER);

        Label carRental = new Label("Car Rental: ");
        TextField carRentalTextField = new TextField("0");
        HBox carRentalHBox = new HBox(10,carRental,carRentalTextField);
        carRentalHBox.setAlignment(Pos.CENTER);

        Label milesDriven = new Label("Miles Driven: ");
        TextField milesDrivenTextField = new TextField("0");
        HBox milesDrivenHBox = new HBox(10,milesDriven,milesDrivenTextField);
        milesDrivenHBox.setAlignment(Pos.CENTER);

        Label parkingFeesLabel  = new Label("Parking Fees: ");
        TextField parkingFeesTextField = new TextField("0");
        HBox parkingFeesHBox = new HBox(10,parkingFeesLabel,parkingFeesTextField);
        parkingFeesHBox.setAlignment(Pos.CENTER);

        Label taxiFees = new Label("Taxi Fees: ");
        TextField taxiFeesTextField = new TextField("0");
        HBox taxiFeesHBox = new HBox(10, taxiFees, taxiFeesTextField);
        taxiFeesHBox.setAlignment(Pos.CENTER);

        Label registrationFees = new Label ("Registration Fees: ");
        TextField registrationFeesTextField = new TextField("0");
        HBox registrationFeesHBox = new HBox(10,registrationFees,registrationFeesTextField);
        registrationFeesHBox.setAlignment(Pos.CENTER);

        Label nightlyLodgingFees = new Label("Nightly Lodging Fees: ");
        TextField nightlyLodgingFeesTextField = new TextField("0");
        HBox nightlyLodgingFeesHBox = new HBox(10,nightlyLodgingFees,nightlyLodgingFeesTextField);
        nightlyLodgingFeesHBox.setAlignment(Pos.CENTER);

        Label totalExpenses = new Label("Total Expenses: ");
        Label totalExpensesOutputLabel = new Label();
        HBox totalExpensesHBox = new HBox(10,totalExpenses,totalExpensesOutputLabel);
        totalExpensesHBox.setAlignment(Pos.CENTER_LEFT);

        Label allowableExpenses = new Label("Allowable Expenses: ");
        Label allowableExpensesOutputLabel = new Label();
        HBox allowableExpensesHBox = new HBox(10,allowableExpenses,allowableExpensesOutputLabel);
        allowableExpensesHBox.setAlignment(Pos.CENTER_LEFT);

        Label excessExpenses = new Label("Excess Expenses: ");
        Label excessExpensesOutputLabel = new Label();
        HBox excessExpensesHBox = new HBox(10,excessExpenses,excessExpensesOutputLabel);
        excessExpensesHBox.setAlignment(Pos.CENTER_LEFT);

        Label savedExpenses = new Label("Saved Expenses: ");
        Label savedExpensesOutputLabel = new Label();
        HBox savedExpensesHBox = new HBox(10, savedExpenses, savedExpensesOutputLabel);
        savedExpensesHBox.setAlignment(Pos.CENTER_LEFT);

        Button button = new Button("Calculate Expenses");
        button.setAlignment(Pos.CENTER);

        button.setOnAction(e -> {
            double totalSpent = (Double.parseDouble(daysOnTripTextField.getText())* Double.parseDouble(nightlyLodgingFeesTextField.getText()))
                    + Double.parseDouble(airfareTextField.getText()) + Double.parseDouble(carRentalTextField.getText()) + (
                            Double.parseDouble(milesDrivenTextField.getText()) * perMile) + Double.parseDouble(parkingFeesTextField.getText()) +
                    Double.parseDouble(taxiFeesTextField.getText()) + (Double.parseDouble(daysOnTripTextField.getText()) * meals) + Double.parseDouble(registrationFeesTextField.getText()
            );

            double totalAllowable = (Double.parseDouble(daysOnTripTextField.getText()) * lodgingPerDay) + Double.parseDouble(airfareTextField.getText()) + Double.parseDouble(carRentalTextField.getText()) + (
                    Double.parseDouble(milesDrivenTextField.getText()) * perMile) + (Double.parseDouble(daysOnTripTextField.getText()) * parkingFees) +
                    (Double.parseDouble(daysOnTripTextField.getText()) * taxiPerDay) + (Double.parseDouble(daysOnTripTextField.getText()) *
                    meals) + Double.parseDouble(registrationFeesTextField.getText());

            double excess = totalSpent - totalAllowable;
            double saved = totalAllowable - totalSpent;

            totalExpensesOutputLabel.setText(String.format("%.2f", totalSpent));
            allowableExpensesOutputLabel.setText(String.format("%.2f",totalAllowable));

            if(excess < 0){
               excess = 0;
            }
            savedExpensesOutputLabel.setText(String.format("%.2f",saved));
            excessExpensesOutputLabel.setText(String.format("%.2f", excess));
        });

            VBox mainVBox = new VBox(10,daysOnTripHBox, airfareHBox, carRentalHBox, milesDrivenHBox, parkingFeesHBox,
                    taxiFeesHBox, registrationFeesHBox, nightlyLodgingFeesHBox, totalExpensesHBox, allowableExpensesHBox, excessExpensesHBox,
                    savedExpensesHBox, button);
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
