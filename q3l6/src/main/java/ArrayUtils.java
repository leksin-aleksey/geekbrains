import java.util.Arrays;

public class ArrayUtils {

    private static final int TRIM_NUMBER = 4;
    private static final int CHECK_NUMBER_1 = 1;
    private static final int CHECK_NUMBER_2 = 4;


    public static int[] trimArrayByFour(int[] arr){
        int i = arr.length;
        while (i-- >= 0){
            if(arr[i] == TRIM_NUMBER) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("No 4 in the array");
    }

    public static boolean checkArrayOnOneAndFour(int[] arr){
        boolean containsNumber1 = false;
        boolean containsNumber2 = false;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == CHECK_NUMBER_1){
                containsNumber1 = true;
            } else if (arr[i] == CHECK_NUMBER_2){
                containsNumber2 = true;
            }
            if(containsNumber1 && containsNumber2){
                return true;
            }
        }
        return false;
    }
}
