package Model;

import Exceptions.SizeException;

public class SizeModel {

    public static int[] castStringToNumbers(String rowsString, String columnString) throws SizeException {
        int[] matrixSizes = new int[2];
        if(rowsString.length() == 0) throw new SizeException(1);
        if(columnString.length() == 0) throw new SizeException(1);
        matrixSizes[0] = Integer.parseInt(rowsString);
        matrixSizes[1] = Integer.parseInt(columnString);

        return matrixSizes;
    }

}
