package View;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class OperationView extends Application {
    private static double xOffset = 0;
    private static double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void initOperationView(int typeOperation, int[] sizes){
        Scene scene;
        if(typeOperation == 1){
            scene = new Scene(oneMatrixOperation(sizes));
        }else{
            scene = new Scene(twoMatrixOperation(sizes));
        }
        final Stage primaryStage = new Stage();

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Operacion");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static Pane oneMatrixOperation(int[] sizes){
        final FXMLLoader loader = new FXMLLoader(OperationView.class.getResource("/views/operationOneMatrix.fxml"));
        Pane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScrollPane matrixPane = (ScrollPane) root.getChildren().get(0);
        matrixPane.setContent(createContent(sizes,600));

        return root;
    }

    public static Pane twoMatrixOperation(int[] sizes){
        final FXMLLoader loader = new FXMLLoader(OperationView.class.getResource("/views/operationTwoMatrix.fxml"));
        Pane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScrollPane firstMatrix = (ScrollPane) root.getChildren().get(0);
        firstMatrix.setContent(createContent(sizes,300));

        ScrollPane secondMatrix = (ScrollPane) root.getChildren().get(1);
        secondMatrix.setContent(createContent(sizes,300));

        return root;
    }

    //size of a component 40x40
    public static VBox createContent(int[] sizes,int width){
        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setPrefHeight(400);
        content.setPrefWidth(width);
        for(int row = 0; row < sizes[0]; row++){
            HBox rowContent = new HBox();
            for(int column = 0; column < sizes[1]; column++){
                rowContent.getChildren().add(createTextArea());
                rowContent.setAlignment(Pos.CENTER);
            }
            content.getChildren().add(rowContent);
        }
        return content;
    }

    public static TextField createTextArea(){
        final TextField field = new TextField();
        field.setPrefHeight(40);
        field.setPrefWidth(50);
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        return field;
    }
}
