package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class History {
    private static final String FILE_HISTORY = "history.txt";
    private static final int MAX_LINES = 100;

    List<String> history = new LinkedList<>();

    public History() {
        File historyFile = new File(FILE_HISTORY);

        try {
            if (!historyFile.createNewFile()){
                try (BufferedReader br = new BufferedReader(new FileReader(historyFile))){
                    String line;
                    int counter = 0;
                    while ((line = br.readLine()) != null && counter++ < MAX_LINES){
                        history.add(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileHistory() {
        return FILE_HISTORY;
    }

    public static int getMaxLines() {
        return MAX_LINES;
    }

    public List<String> getHistory() {
        return history;
    }

}
