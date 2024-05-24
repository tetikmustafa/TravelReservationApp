package org.example.travelreservationapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.scene.layout.HBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;


public class MainController implements Initializable {
    @FXML
    VBox vBox;
    @FXML
    Label cityName;
    @FXML
    Label cityDate;
    @FXML
    Label cityDescription;
    @FXML
    Label cityTime;
    Stack<City> citiesList = new Stack<>();
    Boolean isPackDetailsOpen = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readJson();
    }
    public void addToCart(City city) throws IOException {
        HBox root = new HBox();
        String path = "file:src/main/resources/org/example/travelreservationapp/Background.jpeg";
        root.setStyle("-fx-background-image: url("+path+");-fx-background-size: cover;");
        VBox vbox = new VBox();

        Pane pane1 = new Pane();
        pane1.setPrefHeight(100.0);
        pane1.setPrefWidth(600.0);
        pane1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

        Label label1 = new Label("Travel Reservation App");
        label1.setLayoutX(125);
        label1.setLayoutY(33.0);
        label1.setFont(new Font("System Bold", 24.0));
        label1.setEffect(new Bloom());
        label1.setStyle("-fx-text-fill: #24ff00;");

        pane1.getChildren().add(label1);

        Pane pane2 = new Pane();
        pane2.setPrefHeight(300.0);
        pane2.setPrefWidth(600.0);

        Button buyButton = new Button("Buy");
        buyButton.setLayoutX(480.0);
        buyButton.setLayoutY(210.0);
        buyButton.setPrefHeight(40.0);
        buyButton.setPrefWidth(88.0);
        buyButton.setStyle("-fx-background-color: lightgray;");

        buyButton.setFont(new Font(15.0));

        buyButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) buyButton.getScene().getWindow();
            stage.close();
        });

        Label cityPrice = new Label("Price: "+String.valueOf(city.getPrice()));
        cityPrice.setLayoutX(380.0);
        cityPrice.setLayoutY(207.0);
        cityPrice.setPrefHeight(40.0);
        cityPrice.setPrefWidth(100.0);
        cityPrice.setFont(new Font(14.0));
        cityPrice.setStyle("-fx-text-fill: #24ff00;");

        Label cityName = new Label(city.getName());
        cityName.setLayoutX(50.0);
        cityName.setLayoutY(35.0);
        cityName.setPrefWidth(300.0);
        cityName.setFont(new Font(21.0));
        cityName.setStyle("-fx-text-fill: #24ff00;");

        Label cityDate = new Label("Date: "+city.getBeginningDate()+" - "+city.getEndDate());
        cityDate.setLayoutX(50.0);
        cityDate.setLayoutY(95.0);
        cityDate.setPrefWidth(300.0);
        cityDate.setFont(new Font(21.0));
        cityDate.setStyle("-fx-text-fill: #24ff00;");

        Label cityDescription = new Label("Description: "+city.getDescription());
        cityDescription.setLayoutX(50.0);
        cityDescription.setLayoutY(155.0);
        cityDescription.setPrefWidth(300.0);
        cityDescription.setFont(new Font(13.0));
        cityDescription.setStyle("-fx-text-fill: #24ff00;");
        cityDescription.setWrapText(true);

        Label cityTime = new Label("Time: "+city.getTime());
        cityTime.setLayoutX(50.0);
        cityTime.setLayoutY(125);
        cityTime.setPrefWidth(300.0);
        cityTime.setFont(new Font(21.0));
        cityTime.setStyle("-fx-text-fill: #24ff00;");

        Label nameLabel = new Label("Name:");
        nameLabel.setLayoutX(360);
        nameLabel.setLayoutY(35.0);
        nameLabel.setStyle("-fx-font-size: 18;-fx-text-fill: #24ff00;");

        TextField name = new TextField();
        name.setLayoutX(440.0);
        name.setLayoutY(35.0);
        name.setPrefHeight(24.0);
        name.setPrefWidth(138.0);
        name.setStyle("-fx-background-color: lightgray;");

        Label phoneNumberLabel = new Label("Number:");
        phoneNumberLabel.setLayoutX(360);
        phoneNumberLabel.setLayoutY(115.0);
        phoneNumberLabel.setStyle("-fx-font-size: 18;-fx-text-fill: #24ff00;");

        TextField phoneNumber = new TextField();
        phoneNumber.setLayoutX(440.0);
        phoneNumber.setLayoutY(115.0);
        phoneNumber.setPrefHeight(24.0);
        phoneNumber.setPrefWidth(138.0);
        phoneNumber.setStyle("-fx-background-color: lightgray;");

        Label emailLabel = new Label("E-mail:");
        emailLabel.setLayoutX(360);
        emailLabel.setLayoutY(155.0);
        emailLabel.setStyle("-fx-font-size: 18;-fx-text-fill: #24ff00;");

        TextField email = new TextField();
        email.setLayoutX(440.0);
        email.setLayoutY(155.0);
        email.setPrefHeight(24.0);
        email.setPrefWidth(138.0);
        email.setStyle("-fx-background-color: lightgray;");

        Label surnameLabel = new Label("Surname:");
        surnameLabel.setLayoutX(360);
        surnameLabel.setLayoutY(75.0);
        surnameLabel.setStyle("-fx-font-size: 18;-fx-text-fill: #24ff00;");

        TextField surname = new TextField();
        surname.setLayoutX(440.0);
        surname.setLayoutY(75.0);
        surname.setPrefHeight(24.0);
        surname.setPrefWidth(138.0);
        surname.setStyle("-fx-background-color: lightgray;");

        pane2.getChildren().addAll(
                buyButton, cityPrice, cityName, cityDate, cityDescription, cityTime,
                nameLabel, name, phoneNumberLabel, phoneNumber, emailLabel, email,
                surnameLabel, surname);

        vbox.getChildren().addAll(pane1, pane2);

        root.getChildren().add(vbox);

        Stage stage = new Stage();

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void packDetails(TravelPackList travelPacks,TravelPack travelPack) throws IOException {
        if(isPackDetailsOpen){
            return;
        }else {
            isPackDetailsOpen = true;

        HBox hbox = new HBox();
        hbox.setAlignment(javafx.geometry.Pos.CENTER);

        String path = "file:src/main/resources/org/example/travelreservationapp/Background2.jpg";
        hbox.setStyle("-fx-background-image: url("+path+");-fx-background-size: cover;");

        VBox vbox = new VBox();

        Pane pane1 = new Pane();
        pane1.setPrefSize(600, 100);
        pane1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");

        Label titleLabel = new Label("Travel Reservation App");
        titleLabel.setLayoutX(125);
        titleLabel.setLayoutY(33);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setStyle("-fx-text-fill: #24ff00;");
        titleLabel.setFont(new Font("System Bold", 24.0));
        titleLabel.setEffect(new Bloom());

        Button backButton = new Button("Back");
        backButton.setLayoutX(456);
        backButton.setLayoutY(14);
        backButton.setStyle("-fx-background-color: lightgray;");

        backButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) hbox.getScene().getWindow();
            isPackDetailsOpen = false;
            stage.close();
            try {
                packDetails(travelPacks,travelPacks.getPrevious(travelPack));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Button forwardButton = new Button("Forward");
        forwardButton.setLayoutX(529);
        forwardButton.setLayoutY(14);
        forwardButton.setStyle("-fx-background-color: lightgray;");

        forwardButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) hbox.getScene().getWindow();
            isPackDetailsOpen = false;
            stage.close();
            try {
                packDetails(travelPacks,travelPacks.getNext(travelPack));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        pane1.getChildren().addAll(titleLabel, backButton, forwardButton);

        Pane pane2 = new Pane();
        pane2.setPrefSize(600, 300);

        Label travelPackName = new Label(travelPack.getName());
        travelPackName.setLayoutX(245);
        travelPackName.setLayoutY(20);
        travelPackName.setStyle("-fx-font-size: 24;-fx-text-fill: #000000;");

        Label travelPackPrice = new Label("Price: "+String.valueOf(travelPack.getPrice()));
        travelPackPrice.setLayoutX(450);
        travelPackPrice.setLayoutY(25);
        travelPackPrice.setStyle("-fx-font-size: 18;-fx-text-fill: #000000;");

        Label travelPackLocations = new Label("Locations: "+travelPack.printLocations());
        travelPackLocations.setLayoutX(40);
        travelPackLocations.setLayoutY(150);
        travelPackLocations.setStyle("-fx-font-size: 18;-fx-text-fill: #000000;");

        Label travelPackActivities = new Label("Activities: "+travelPack.printActivities());
        travelPackActivities.setLayoutX(40);
        travelPackActivities.setLayoutY(230);
        travelPackActivities.setStyle("-fx-font-size: 18;-fx-text-fill: #000000;");


        Label cityName = new Label(travelPacks.getCityName());
        cityName.setLayoutX(40);
        cityName.setLayoutY(25);
        cityName.setStyle("-fx-font-size: 18;-fx-text-fill: #000000;");

        Label travelPackDescription = new Label("Description: "+travelPack.getDescription());
        travelPackDescription.setLayoutX(40);
        travelPackDescription.setLayoutY(85);
        travelPackDescription.setPrefWidth(500);
        travelPackDescription.setStyle("-fx-font-size: 15;-fx-text-fill: #000000;");
        travelPackDescription.setWrapText(true);

        pane2.getChildren().addAll(
                travelPackName,
                travelPackPrice,
                travelPackLocations,
                travelPackActivities,
                cityName,
                travelPackDescription
        );

        vbox.getChildren().addAll(pane1, pane2);
        hbox.getChildren().add(vbox);



        Stage stage = new Stage();
        Scene scene = new Scene(hbox, 600, 400);

        stage.setOnCloseRequest(e -> {
            isPackDetailsOpen = false;
        });

        stage.setScene(scene);
        stage.show();
        }
    }
    public Pane createCityPane(City city) throws IOException {
        Pane pane = new Pane();
        pane.setPrefSize(600, 150);

        String path = "file:src/main/resources/org/example/travelreservationapp/"+city.getName()+".jpeg";
        pane.setStyle("-fx-background-image: url("+path+");-fx-background-size: cover;");

        Label cityName = new Label(city.getName());
        cityName.setFont(new javafx.scene.text.Font(23));
        cityName.setLayoutX(20);
        cityName.setLayoutY(10);
        cityName.setStyle("-fx-text-fill: white;");

        Font font = new Font(18);

        Label cityDate = new Label("Date: "+city.getBeginningDate()+" - "+city.getEndDate());
        cityDate.setFont(font);
        cityDate.setLayoutX(20);
        cityDate.setLayoutY(50);
        cityDate.setStyle("-fx-text-fill: white;");

        Label cityTime = new Label("Time: "+city.getTime());
        cityDate.setFont(font);
        cityTime.setLayoutX(20);
        cityTime.setLayoutY(80);
        cityTime.setStyle("-fx-text-fill: white;");

        Label cityDescription = new Label("Description: "+city.getDescription());
        cityDate.setFont(font);
        cityDescription.setLayoutX(20);
        cityDescription.setLayoutY(100);
        cityDescription.setPrefWidth(250);
        cityDescription.setStyle("-fx-font-size: 13;-fx-text-fill: white;");
        cityDescription.setWrapText(true);

        RadioButton travelPack1 = new RadioButton();
        travelPack1.setLayoutX(300);
        travelPack1.setLayoutY(30);
        travelPack1.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        Label travelPack1Name = new Label("Travel Pack1");
        travelPack1Name.setLayoutX(320);
        travelPack1Name.setLayoutY(30);
        travelPack1Name.setStyle("-fx-text-fill: white;");


        RadioButton travelPack2 = new RadioButton();
        travelPack2.setLayoutX(400);
        travelPack2.setLayoutY(30);
        travelPack2.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        Label travelPack2Name = new Label("Travel Pack1");
        travelPack2Name.setLayoutX(420);
        travelPack2Name.setLayoutY(30);
        travelPack2Name.setStyle("-fx-text-fill: white;");

        RadioButton travelPack3 = new RadioButton();
        travelPack3.setLayoutX(300);
        travelPack3.setLayoutY(90);
        travelPack3.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        Label travelPack3Name = new Label("Travel Pack1");
        travelPack3Name.setLayoutX(320);
        travelPack3Name.setLayoutY(90);
        travelPack3Name.setStyle("-fx-text-fill: white;");

        RadioButton travelPack4 = new RadioButton();
        travelPack4.setLayoutX(400);
        travelPack4.setLayoutY(90);
        travelPack4.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        Label travelPack4Name = new Label("Travel Pack1");
        travelPack4Name.setLayoutX(420);
        travelPack4Name.setLayoutY(90);
        travelPack4Name.setStyle("-fx-text-fill: white;");

        Label travelPack1Price = new Label("Price");
        travelPack1Price.setAlignment(javafx.geometry.Pos.CENTER);
        travelPack1Price.setLayoutX(300);
        travelPack1Price.setLayoutY(60);
        travelPack1Price.setStyle("-fx-text-fill: white;");

        Label travelPack2Price = new Label("Price");
        travelPack2Price.setAlignment(javafx.geometry.Pos.CENTER);
        travelPack2Price.setLayoutX(400);
        travelPack2Price.setLayoutY(60);
        travelPack2Price.setStyle("-fx-text-fill: white;");

        Label travelPack3Price = new Label("Price");
        travelPack3Price.setAlignment(javafx.geometry.Pos.CENTER);
        travelPack3Price.setLayoutX(300);
        travelPack3Price.setLayoutY(120);
        travelPack3Price.setStyle("-fx-text-fill: white;");

        Label travelPack4Price = new Label("Price");
        travelPack4Price.setAlignment(javafx.geometry.Pos.CENTER);
        travelPack4Price.setLayoutX(400);
        travelPack4Price.setLayoutY(120);
        travelPack4Price.setStyle("-fx-text-fill: white;");

        Label cityPrice = new Label("Price: "+String.valueOf(city.getPrice()));
        cityPrice.setAlignment(javafx.geometry.Pos.CENTER);
        cityPrice.setLayoutX(500);
        cityPrice.setLayoutY(30);
        cityPrice.setStyle("-fx-text-fill: white;");

        for(int i=0;i<city.getTravelPacks().size();i++){
            if(i<city.getTravelPacks().size()){
                switch (i){
                    case 0:
                        travelPack1Name.setText(city.getTravelPacks().get(i).getName());
                        travelPack1Price.setText("Price: "+String.valueOf(city.getTravelPacks().get(i).getPrice()));
                        break;
                    case 1:
                        travelPack2Name.setText(city.getTravelPacks().get(i).getName());
                        travelPack2Price.setText("Price: "+String.valueOf(city.getTravelPacks().get(i).getPrice()));
                        break;
                    case 2:
                        travelPack3Name.setText(city.getTravelPacks().get(i).getName());
                        travelPack3Price.setText("Price: "+String.valueOf(city.getTravelPacks().get(i).getPrice()));
                        break;
                    case 3:
                        travelPack4Name.setText(city.getTravelPacks().get(i).getName());
                        travelPack4Price.setText("Price: "+String.valueOf(city.getTravelPacks().get(i).getPrice()));
                        break;
                }
            }
        }
        travelPack1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                city.setPrice(city.getPrice()+city.getTravelPacks().get(0).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }else {
                city.setPrice(city.getPrice()-city.getTravelPacks().get(0).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }
        });
        travelPack2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                city.setPrice(city.getPrice()+city.getTravelPacks().get(1).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }else {
                city.setPrice(city.getPrice()-city.getTravelPacks().get(1).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }
        });
        travelPack3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                city.setPrice(city.getPrice()+city.getTravelPacks().get(2).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }else {
                city.setPrice(city.getPrice()-city.getTravelPacks().get(2).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }
        });
        travelPack4.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                city.setPrice(city.getPrice()+city.getTravelPacks().get(3).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }else {
                city.setPrice(city.getPrice()-city.getTravelPacks().get(3).getPrice());
                cityPrice.setText("Price: "+String.valueOf(city.getPrice()));
            }
        });
        travelPack1Name.setOnMouseClicked(e -> {
            try {
                packDetails(city.getTravelPacks(),city.getTravelPacks().get(0));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        travelPack2Name.setOnMouseClicked(e -> {
            try {
                packDetails(city.getTravelPacks(),city.getTravelPacks().get(1));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        travelPack3Name.setOnMouseClicked(e -> {
            try {
                packDetails(city.getTravelPacks(),city.getTravelPacks().get(2));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        travelPack4Name.setOnMouseClicked(e -> {
            try {
                packDetails(city.getTravelPacks(),city.getTravelPacks().get(3));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Button addToCartButton = new Button("Add To Cart");
        addToCartButton.setLayoutX(500);
        addToCartButton.setLayoutY(90);
        addToCartButton.setStyle("-fx-background-color: lightgray;");

        addToCartButton.setOnMouseClicked(e -> {
            try {
                addToCart(city);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        pane.getChildren().addAll(
//                cityImage,
                cityName,
                cityDate,
                cityTime,
                cityDescription,
                travelPack1Name,
                travelPack2Name,
                travelPack3Name,
                travelPack4Name,
                travelPack1,
                travelPack2,
                travelPack3,
                travelPack4,
                travelPack1Price,
                travelPack2Price,
                travelPack3Price,
                travelPack4Price,
                cityPrice,
                addToCartButton
        );
        return pane;
    }
    public void addCityPanes(City city){
        try {
            vBox.getChildren().add(createCityPane(city));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readJson() {
        try (FileReader reader = new FileReader("cities.json")) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Map<String, Map<String, String>>>>(){}.getType();
            Map<String, Map<String, Map<String, String>>> cities = gson.fromJson(reader, type);
           for(Map.Entry<String, Map<String, Map<String, String>>> entry : cities.entrySet()) {
//               System.out.println(entry.getKey());
               City city = new City();
               for (Map.Entry<String, Map<String, String>> entry2 : entry.getValue().entrySet()) {
//                   System.out.println(entry2.getKey());
                   if(entry2.getKey().equals("Properties")){
                       for (Map.Entry<String, String> entry3 : entry2.getValue().entrySet()) {
//                           System.out.println(entry3.getKey() + ": " + entry3.getValue());
                           city.setVariable(entry3.getKey(), entry3.getValue());
                       }
                   }else {
                       TravelPack travelPack = new TravelPack();
                       for (Map.Entry<String, String> entry3 : entry2.getValue().entrySet()) {
//                           System.out.println(entry3.getKey() + ": " + entry3.getValue());
                           travelPack.setVariable(entry3.getKey(), entry3.getValue());
                       }
                       city.addTravelPack(travelPack);
                   }
               }
               city.getTravelPacks().setCityName(city.getName());
               citiesList.push(city);
               addCityPanes(city);
           }
        } catch (IOException e) {
            System.err.println("File read failed: " + e.getMessage());
        }
    }
}