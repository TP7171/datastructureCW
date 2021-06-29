package datastructurecw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Gui extends Application {

    Scene scene, scene2;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game of Thrones");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        
        
        //hashmap to save all characters
        HashMap<String, person> map = new HashMap<>();
        
        //call the fileReader method to read the txt file
        fileReader.loadData("got.txt", map);
        
        //save the map into a collection
        Collection<person> collValues = map.values();
        
        ArrayList<person> listOfValues;
        listOfValues = new ArrayList<>(collValues);
        //sort the list by name
        listOfValues.sort(Comparator.comparing(person::getName));
        
        
        //grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(40, 40, 40, 40));

        // add scence title
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        
        //welcome button
        Button btn = new Button("WELCOME");
        btn.setMinSize(50, 50);

        //Getting style sheet in login button
        btn.getStyleClass().add("btn");

        //Adding the button in hbox
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 47);
        
        
        // Event handler for welcome button
        btn.setOnAction((javafx.event.ActionEvent e) -> {
            primaryStage.setScene(scene2);
        });
        
        // load backgroud image for welcome screen
        Image im = new Image("/Images/thrones.jpg");
        ImageView mb = new ImageView(im);

        
        // declaring and setting pane
        StackPane spane = new StackPane();
        spane.setAlignment(Pos.CENTER);
        spane.getStyleClass().add("background");
        spane.getChildren().addAll(mb, grid);

        // Setting the scene in a stage
        scene = new Scene(spane, 960, 600);
        //Getting style sheet in login page
        scene.getStylesheets().add(getClass().getResource("Css.css").toExternalForm());
        primaryStage.show();
        primaryStage.setScene(scene);

        // create menuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getStyleClass().add("menu-bar");
        Menu menu = new Menu("");
        menu.setGraphic(new ImageView("Images/logo.png"));
        menu.setOnAction((ActionEvent e) -> {

            primaryStage.setScene(scene);
        });
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Export");
        Menu menuHelp = new Menu("Help");
        AlertBox aExp = new AlertBox();

        // create menuitems for file menu
        MenuItem menuFile4 = new MenuItem("Back");
        
        //event handler for back
        menuFile4.setOnAction((ActionEvent e) -> {

            primaryStage.setScene(scene);
        });
        
        //event handler for exit
        MenuItem menuFile5 = new MenuItem("Exit");
        menuFile5.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        // create menuitems for edit menu
        MenuItem menuEdit1 = new MenuItem("Export Relation Graph");
        
        // Event handler for Export Relations
        menuEdit1.setOnAction((ActionEvent e) -> {
            
            Exporter.graph(listOfValues);

            aExp.display("Message", "The Relation Graph was saved", "OK");

        });
        MenuItem menuEdit2 = new MenuItem("Export Kill Graph");
        menuEdit2.setOnAction((ActionEvent e) -> {
            Exporter.graphKills(listOfValues);
            aExp.display("Message", "The Kill Graph was saved", "OK");

        });
        MenuItem menuEdit3 = new MenuItem("Export All Relations");
        menuEdit3.setOnAction((ActionEvent e) -> {
            Exporter.graphAll(listOfValues);
            aExp.display("Message", "The All Relation Graph was saved", "OK");

        });
        MenuItem menuEdit4 = new MenuItem("Export Text File");
        menuEdit4.setOnAction((ActionEvent e) -> {
            Saver.saver(listOfValues);
            aExp.display("Message", "The File was saved", "OK");

        });

        // create menuitems for help menu
        MenuItem menuHelp1 = new MenuItem("Information about Students");
        menuHelp1.setOnAction((ActionEvent e) -> {
            String s1;
            String s2 = "u1730779 - Riya Sharma";
            String s3 = "u1741509 - Santosh Bhattarai";
            String s4 = "u1817196 - Jeronimo Lopes";
            s1 = "u1724377 - Thiago Pillonetto";
            aExp.display("Students Information", "Group 6" + "\n" + s1 + "\n" + s2 + "\n" + s3 + "\n" + s4, "OK");

        });

        MenuItem menuHelp2 = new MenuItem("References");
        menuHelp2.setOnAction((ActionEvent e) -> {
            String s1;
            String s2 = "http://viewers-guide.hbo.com/game-of-thrones/season-8/episode-2/houses";
            String s3 = "https://gameofthrones.fandom.com/wiki/Great_House";
            String s4 = "https://i.pinimg.com/originals/d6/e8/c5/d6e8c572d73d984fbd2413c494d5a240.png";
            s1 = "https://2.bp.blogspot.com/-pASmQ80S1so/Ub4zwV5OfTI/AAAAAAAAODA/EVDsPTv_rsI/w1200-h630-p-k-no-nu/Game-Of-Thrones-Family-Tree.jpg";
            String s5 = "https://pbs.twimg.com/media/DIkKv1SUMAElTlj.jpg";
            aExp.display("References", s1 + "\n" + s2 + "\n" + s3 + "\n" + s4 + "\n" + s5, "OK");

        });

        // add menu items to file
        menuFile.getItems().add(menuFile4);
        menuFile.getItems().add(menuFile5);

        // add menu items to export
        menuEdit.getItems().add(menuEdit1);
        menuEdit.getItems().add(menuEdit2);
        menuEdit.getItems().add(menuEdit3);
        menuEdit.getItems().add(menuEdit4);

        // add menu items to help 
        menuHelp.getItems().add(menuHelp1);
        menuHelp.getItems().add(menuHelp2);

        menuBar.getMenus().addAll(menu, menuFile, menuEdit, menuHelp);

        ComboBox name1 = new ComboBox();
        name1.getStyleClass().add("box");
        name1.setMaxSize(250, 10);
        name1.setPromptText("Select First Name");
        name1.setEditable(false);

        ComboBox name2 = new ComboBox();
        name2.getStyleClass().add("box");
        name2.setMaxSize(270, 10);
        name2.setPromptText("Select Second Name");
        name2.setEditable(false);

        Button btn1 = new Button("Compare");
        //Setting up the size of the buttons
        btn1.setMinSize(150, 50);
        //Getting style sheet in home buttons

        btn1.setOnAction((ActionEvent e) -> {

            try {
                String n1 = name1.getValue().toString();
                String n2 = name2.getValue().toString();
                String r;
                if (!n1.equals(n2)) {

                    try {
                        r = RelationCheck.compare(n1, n2, map);
                        if (!"not related".equals(r)) {
                            aExp.display("Comparing " + n1 + " and " + n2, (n1 + " is " + n2 + " " + r), "OK");
                        } else {
                            aExp.display("Comparing " + n1 + " and " + n2, r, "OK");
                        }

                    } catch (Exception ex) {
                        aExp.display("Comparing " + n1 + " and " + n2, "not related", "OK");
                    }

                } else {
                    aExp.display("Error", "Please select different persons to compare", "OK");
                }

            } catch (Exception ex) {

                aExp.display("Error", "Please select 2 persons to compare", "OK");
            }

        });
        btn1.getStyleClass().add("box");

        ComboBox name3 = new ComboBox();
        name3.getStyleClass().add("box-1");
        name3.setMinSize(140, 45);
        name3.setPromptText("List of Characters");
        name3.setEditable(false);

        // create a VBox for menu bar
        VBox vb = new VBox(menuBar);
        vb.setAlignment(Pos.TOP_LEFT);

        //Displaying buttons in HBox
        HBox buttbox = new HBox(15);
        buttbox.setAlignment(Pos.CENTER);
        buttbox.getChildren().addAll(name1, name2, btn1);

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(vb, buttbox, name3);

        Image im1 = new Image("/Images/familytree.jpg");
        ImageView mb1 = new ImageView(im1);

        //Adding image and hbox in stack pane
        StackPane spane1 = new StackPane();
        spane1.setAlignment(Pos.CENTER_RIGHT);
        spane1.getStyleClass().add("background");
        spane1.getChildren().addAll(mb1, vbox);

        scene2 = new Scene(spane1, 960, 600);
        scene2.getStylesheets().add(getClass().getResource("Css.css").toExternalForm());

        name3.setOnAction(e -> {
            String name = name3.getValue().toString();
            String gender = map.get(name).getGender();
            String mother = map.get(name).getMother();
            String father = map.get(name).getFather();
            String married = map.get(name).getMarried();
            String status;

            if ((!"Alive".equals(map.get(name).getStatus())) && ((!"Dead".equals(map.get(name).getStatus())))) {
                status = "Killed by " + map.get(name).getStatus();
            } else {
                status = map.get(name).getStatus();
            }

            String out = "Name: " + name + "\n" + "Gender: " + gender + "\n" + "Mother: " + mother + "\n" + "Father: " + father + "\n" + "Married to: " + married + "\n" + "Status: " + status;
            aExp.display("Summary of " + name, out, "OK");
        });
        updComboBox(listOfValues, name1, name2, name3);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void updComboBox(ArrayList<person> listOfValues, ComboBox name1, ComboBox name2, ComboBox name3) {
        for (int i = 0; i < listOfValues.size(); i++) {
            name1.getItems().add(i, listOfValues.get(i).getName());
            name2.getItems().add(i, listOfValues.get(i).getName());
            name3.getItems().add(i, listOfValues.get(i).getName());

        }

    }

}
