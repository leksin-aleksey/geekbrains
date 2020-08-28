import com.geekbrains.java.course.custom.YellowPages;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        String[] words = new String[]{
                "ivanov",
                "petrov",
                "ivanov",
                "sidorov",
                "petrov",
                "kuznecov",
                "ivanov",
                "petrenko",
                "ivanov",
                "ivanov",
                "ivanov-kramarov"
        };
        //1
        countDuplicates(words);

        System.out.println();

        //2
        YellowPages yp = new YellowPages();

        yp.add("ivanov", "+123456789");
        yp.add("petrov", "+234");
        yp.add("sidorov", "+888");
        yp.add("sidorov", "+0789");
        yp.add("ivanov", "+1111");
        yp.add("sidorov", "+4798965");

        System.out.println(yp.get("ivanov"));
        System.out.println(yp.get("sidorov"));
    }

    private static void countDuplicates(String[] words){
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            Integer count = map.get(word);

            if(count == null){
                count = 1;
            }
            else{
                count++;
            }
            map.put(word, count);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
