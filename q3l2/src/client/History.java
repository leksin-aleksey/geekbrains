package client;

import java.io.*;
import java.util.ArrayList;
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
        history = new ArrayList<>();
        LinkedList<String> historyLast = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(historyFile))){
            String line;
            while ((line = br.readLine()) != null){
                history.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        if (history.size() <= num) {
            return history;
        } else{
            for (int i = history.size() - num; i < history.size(); i++) {
                historyLast.add(history.get(i));
            }
        }
        return historyLast;
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
