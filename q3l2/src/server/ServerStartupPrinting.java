package server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerStartupPrinting {
    private StringBuffer resultMessage = new StringBuffer();
    private char printedLetter = 'C';
    private final Object lock = new Object();

    public Object getLock() {
        return lock;
    }

    public char getPrintedLetter() {
        return printedLetter;
    }

    public synchronized void setPrintedLetter(char printedLetter) {
        this.printedLetter = printedLetter;
    }

    public synchronized void messageAdd(char c){
        resultMessage.append(c);
    }

    public void print(){
        ServerStartupPrintingLog serverStartupPrintingLogA = new ServerStartupPrintingLog('A', this);
        ServerStartupPrintingLog serverStartupPrintingLogB = new ServerStartupPrintingLog('B', this);
        ServerStartupPrintingLog serverStartupPrintingLogC = new ServerStartupPrintingLog('C', this);

        Thread threadA = new Thread(serverStartupPrintingLogA);
        Thread threadB = new Thread(serverStartupPrintingLogB);
        Thread threadC = new Thread(serverStartupPrintingLogC);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);
        executorService.shutdown();
        System.out.println(resultMessage.toString());
    }
}
