import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        //1
        initGame1();

        //2
        initGame2();

        scanner.close();
    }

    static void initGame1(){
        boolean continueGame = true;
        while (continueGame){
            startGame1();
            continueGame = inquireContinuation();
        }
    }

    static void startGame1(){
        Random random = new Random();
        int guessedNumber = random.nextInt(10);
        for(byte i = 0; i < 3; i++){
            System.out.println("Угадайте число:");
            int userNumber = scanner.nextByte();
            if(guessedNumber < userNumber) System.out.println("Загаданное число меньше");
            else if(guessedNumber > userNumber) System.out.println("Загаданное число больше");
            else{
                System.out.println("Верно");
                return;
            }
        }
        System.out.println("Пускай сегодня не повезло… но игра продолжается!");
    }

    static boolean inquireContinuation(){
        while (true) {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            switch (scanner.nextByte()){
                case 0:
                    return false;
                case 1:
                    return true;
                default: break;
            }
        }
    }

    static void initGame2(){
        String[] words = initGameArray();
        String setWord = getSetWord(words);

        startGame2(setWord);
    }

    static String[] initGameArray(){
        return new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
    }

    static String getSetWord(String[] words){
        Random random = new Random();
        int wordIndx = random.nextInt(25);
        return words[wordIndx];
    }

    static void startGame2(String setWord){

        boolean wordGuessed = false;
        while (!wordGuessed){
            System.out.println("Угадайте слово:");
            String userWord = scanner.nextLine();
            if(userWord.equals(setWord)){
                wordGuessed = true;
                System.out.println("Верно");
            }
            else{
                printPrompt(userWord, setWord);
            }
        }
    }

    static void printPrompt(String userWord, String setWord){
        for(byte b = 0; b < 15; b++){
            try {
                if (userWord.charAt(b) == setWord.charAt(b)) System.out.print(setWord.charAt(b));
                else System.out.print('#');
            }
            catch (IndexOutOfBoundsException e){
                System.out.print('#');
            }
        }
        System.out.println();
    }
}
