package Exceptions;

public class SizeException  extends Exception{
    private int typeError;

    public SizeException(int _typeError){
        typeError = _typeError;
    }

    public String getMessage(){
        String errorMessage = "";
        switch (typeError){
            case 1:
                errorMessage = "Filas o columnas no deben de estar vacias"; break;
            case 2:
                errorMessage = "Filas y columnas deben de ser iguales para este tipo de operacion"; break;
            case 3:
                errorMessage = "Filas o columnas deben ser mayores a 0"; break;
        }
        return  errorMessage;
    }
}
