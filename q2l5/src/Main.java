import com.geekbrains.java.course.threads.ArrayCalc;
import com.geekbrains.java.course.utils.CalcTypes;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        calcInPlain();

        calcInParallel();

    }

    public static void calcInPlain() throws InterruptedException{
        ArrayCalc arrayCalc = new ArrayCalc(CalcTypes.SINGLE);

        long startTime = System.currentTimeMillis();
        arrayCalc.run();

        System.out.println("Single: " + (System.currentTimeMillis() - startTime));
    }

    public static void calcInParallel() throws InterruptedException{
        long startTime = System.currentTimeMillis();

        ArrayCalc arrayCalc2_1 = new ArrayCalc(CalcTypes.PARALLEL1);
        ArrayCalc arrayCalc2_2 = new ArrayCalc(CalcTypes.PARALLEL2);

        Thread thread1 = new Thread(arrayCalc2_1);
        Thread thread2 = new Thread(arrayCalc2_2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Parralel: " + (System.currentTimeMillis() - startTime));
    }
}
