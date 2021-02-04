package View;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {

    public MainView(){ }

    public  MainView(int init){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(configView());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora de matricez");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Pane configView() throws IOException {
        FXMLLoader loaderView = new FXMLLoader();
        loaderView.setLocation(MainView.class.getResource("/views/mainView.fxml"));
        Pane view = loaderView.load();

        final TextField rowsField = (TextField) view.getChildren().get(0);
        rowsField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    rowsField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        final TextField columnsField = (TextField) view.getChildren().get(0);
        columnsField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    columnsField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        return view;
    }

}
