package Controller;

import Exceptions.SizeException;
import Model.SizeModel;
import View.OperationView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField rowsTextFIeld, columnsTextField;

    public void Test(){
        String rowsText = rowsTextFIeld.getText();
        String columsText = columnsTextField.getText();
        try{
            int[] matrixSize = SizeModel.castStringToNumbers(rowsText, columsText);
            if(matrixSize[0] == 0 || matrixSize[1] == 0) throw new SizeException(3);
            OperationView.initOperationView(1, matrixSize);

        }
        catch (SizeException error){
            Alert alert = new Alert(Alert.AlertType.ERROR,error.getMessage());
            alert.show();
        }
    }

    public void Test2(){
        String rowsText = rowsTextFIeld.getText();
        String columsText = columnsTextField.getText();
        try{
            int[] matrixSize = SizeModel.castStringToNumbers(rowsText, columsText);
            if(matrixSize[0] == 0 || matrixSize[1] == 0) throw new SizeException(3);
            OperationView.initOperationView(2, matrixSize);

        }
        catch (SizeException error){
            Alert alert = new Alert(Alert.AlertType.ERROR,error.getMessage());
            alert.show();
        }
    }
}
