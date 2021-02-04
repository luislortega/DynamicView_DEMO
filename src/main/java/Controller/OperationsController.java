package Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class OperationsController {
    @FXML
    private ScrollPane matrixOne, matrixTwoA, matrixTwoB;
    public void calculateOneMatrix(){
        ArrayList<ArrayList> matrix = new ArrayList();
        VBox content = (VBox) matrixOne.getContent();
        for(Node data: content.getChildren()){
            ArrayList<String> rowInfo = new ArrayList<String>();
            HBox row = (HBox) data;
            for(Node dataColumn: row.getChildren()){
                TextField matrixInfo = (TextField) dataColumn;
                rowInfo.add(matrixInfo.getText());
            }
            matrix.add(rowInfo);
        }
        System.out.println(matrix);
    }

    public void calculateTwoMatrix(){

    }
}
