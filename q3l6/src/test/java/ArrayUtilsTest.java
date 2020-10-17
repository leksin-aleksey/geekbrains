import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ArrayUtilsTest {
    @Test
    public void shouldThrowEmptyArrayTrimArrayByFour(){
        Assertions.assertArrayEquals(new int[]{},
                ArrayUtils.trimArrayByFour(new int[]{4}));
        Assertions.assertArrayEquals(new int[]{},
                ArrayUtils.trimArrayByFour(new int[]{4, 4, 4}));
        Assertions.assertArrayEquals(new int[]{},
                ArrayUtils.trimArrayByFour(new int[]{5, 4}));
        Assertions.assertArrayEquals(new int[]{},
                ArrayUtils.trimArrayByFour(new int[]{12,3,3, 7, 5, 4, 1, 0, 65, 4}));
    }

    @Test
    public void shouldReturnCorrectArrayTrimArrayByFour(){
        Assertions.assertArrayEquals(new int[]{1, 0, 50},
                ArrayUtils.trimArrayByFour(new int[]{4, 1, 0, 50}));
        Assertions.assertArrayEquals(new int[]{-100, 0, 65},
                ArrayUtils.trimArrayByFour(new int[]{12,3,3, 7, 5, 4, -100, 0, 65}));
        Assertions.assertArrayEquals(new int[]{44},
                ArrayUtils.trimArrayByFour(new int[]{44, 4, 44}));
        Assertions.assertArrayEquals(new int[]{44, 44},
                ArrayUtils.trimArrayByFour(new int[]{4, 44, 44, 44, 4, 44, 44}));
    }

    @Test
    public void shouldThrowRuntimeExceptionTrimArrayByFour(){
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayUtils.trimArrayByFour(new int[]{});
            }
        });
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayUtils.trimArrayByFour(new int[]{1, 0, 3});
            }
        });
    }

    @Test
    public void shouldReturnTrueCheckArrayOnOneAndFour(){
        Assertions.assertTrue(ArrayUtils.checkArrayOnOneAndFour(new int[]{1, 2, 4, 1}));
        Assertions.assertTrue(ArrayUtils.checkArrayOnOneAndFour(new int[]{1, 4}));
        Assertions.assertTrue(ArrayUtils.checkArrayOnOneAndFour(new int[]{4, 1}));
        Assertions.assertTrue(ArrayUtils.checkArrayOnOneAndFour(new int[]{1, 4, 3, 5, 7}));
    }

    @Test
    public void shouldReturnFalseCheckArrayOnOneAndFour(){
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{}));
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{1, 1}));
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{4, 4}));
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{1, 3}));
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{5, 1}));
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{7, 4}));
        Assertions.assertFalse(ArrayUtils.checkArrayOnOneAndFour(new int[]{1, 44, 444, -4, 4444}));
    }
}
