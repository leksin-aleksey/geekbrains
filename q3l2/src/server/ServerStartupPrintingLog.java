package server;

public class ServerStartupPrintingLog implements Runnable{
    private final char letter;
    private final ServerStartupPrinting serverStartupPrinting;
    private final Object lock;

    public ServerStartupPrintingLog(char letter, ServerStartupPrinting serverStartupPrinting) {
        this.letter = letter;
        this.serverStartupPrinting = serverStartupPrinting;
        lock = serverStartupPrinting.getLock();
    }

    @Override
    public void run() {
        printServerMessage();
    }

    public synchronized void printServerMessage(){
        int i = 0;
        synchronized (lock) {
            while (i < 5) {
                char printedLetter = serverStartupPrinting.getPrintedLetter();
                while (!((printedLetter == 'C' && letter == 'A') ||
                        (printedLetter == 'A' && letter == 'B') ||
                        (printedLetter == 'B' && letter == 'C'))) {
                    try {
                        lock.wait();
                        printedLetter = serverStartupPrinting.getPrintedLetter();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                System.out.print(letter);
                serverStartupPrinting.messageAdd(letter);
                serverStartupPrinting.setPrintedLetter(letter);
                lock.notifyAll();
                i++;
            }
        }
    }
}
