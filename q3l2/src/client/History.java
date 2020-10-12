package client;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class History {
    private static final String FILE_HISTORY_NAME = "history.txt";
    private static final int MAX_LINES_STARTUP = 100;

    private final File historyFile;

    List<String> history;

    public History() {
        historyFile = new File(FILE_HISTORY_NAME);
        try {
            historyFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileHistoryName() {
        return FILE_HISTORY_NAME;
    }

    public static int getMaxLinesStartup() {
        return MAX_LINES_STARTUP;
    }

    public List<String> getHistory() {
        return history;
    }

    public List<String> readAtStartup(){
        return read(MAX_LINES_STARTUP);
    }

    public List<String> read(int num){
        history = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(historyFile))){
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null && counter++ < num){
                history.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return history;
    }

    public boolean write(String s){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(historyFile))){
            bw.write("\n");
            bw.write(s);
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
