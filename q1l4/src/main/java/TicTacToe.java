import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /*
    1. Полностью разобраться с кодом, попробовать переписать с нуля
    2. Доработать все возможные варианты победы
    3. Предусмотреть ничью
    4. Предусмотреть проверку на допустимый диапазон значений вводимых координат пользователем, чтобы не выйти за пределы массива
    5. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока
    */

    public static void main(String[] args){
        startGame();
    }

    private static void startGame(){
        final char playerSign = 'X';
        final char computerSign = '0';
        char[][] field = new char[3][3];

        field = initField();

        drawField(field);

        //the human-player moves first
        int turnNumber = 0;

        GameStatus gameStatus;

        do {
            if(turnNumber % 2 == 0){
                field = doPlayerMove(field, playerSign);
            }
            else{
                field = doAIMove(field, turnNumber, computerSign, playerSign);
            }
            drawField(field);
            turnNumber++;
            gameStatus = getGameStatus(field, turnNumber, playerSign, computerSign);
        }
        while (gameStatus == GameStatus.IN_PROGRESS);

        showGameResult(gameStatus);
    }

    static char[][] initField() {
        return new char[][]{
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'},
        };
    }

    // Отрисока пока как матрицы
    private static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] doPlayerMove(char[][] field, char playerSign){
        Scanner scanner = new Scanner(System.in);
        int xVal, yVal;

        do{
            System.out.println("Please make your move move");
            // Вводим координаты Х, Y
            System.out.println("Please enter X-value [1-3]");
            xVal = scanner.nextInt();
            System.out.println("Please enter Y-value [1-3]");
            yVal = scanner.nextInt();
        }
        while (!checkMoveSanity(field, xVal, yVal));

        field[xVal - 1][yVal - 1] = playerSign;
        return field;
    }

    private static boolean checkMoveSanity(char[][] field, int xVal, int yVal){
        String wrongMoveMessage = "PLease make a correct move";
        try{
            if(field[xVal - 1][yVal - 1] != '-'){
                System.out.println(wrongMoveMessage);
                return false;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(wrongMoveMessage);
            return false;
        }
        return true;
    }

    private static char[][] doAIMove(char[][] field, int turnNumber, char computerSign, char playerSign) {
        Random random = new Random();
        System.out.println("Computer's move...");

        int xVal, yVal;
        xVal = yVal = -1;

        //5
        if(turnNumber >= 2){
            for(int i = 0; i < field.length; i++){
                for(int j = 0; j < field.length; j++){
                    if(field[i][j] == '-'){
                        if(field[i][(j + field.length - 1) % field.length] == playerSign &&
                            field[i][(j + field.length + 1) % field.length] == playerSign){
                            xVal = i;
                            yVal = j;
                        }
                    }
                    if(xVal != -1){
                        break;
                    }
                }
                if(xVal != -1){
                    break;
                }
            }
        }
        if(xVal == -1){
            // Вводим координаты Х, Y
            xVal = random.nextInt(3);
            yVal = random.nextInt(3);

            // Если значение по координатам занято, то делаем перегенерацию координат, пока не найдем свободные
            while (field[xVal][yVal] != '-') {
                xVal = random.nextInt(3);
                yVal = random.nextInt(3);
            }
        }

        System.out.println(String.format("Computer's X-value: %s", xVal));
        System.out.println(String.format("Computer's Y-value: %s", yVal));

        field[xVal][yVal] = computerSign;
        return field;
    }

    private static GameStatus getGameStatus(char[][] field, int turnNumber, char playerSign, char computerSign){
        for(int i = 0; i < field.length; i++) {
            if (field[i][0] != '-' && field[i][0] == field[i][1] && field[i][0] == field[i][2]){
                return field[i][0] == playerSign ? GameStatus.PLAYER_WON : GameStatus.AI_WON;
            }
            if (field[0][i] != '-' && field[0][i] == field[1][i] && field[0][i] == field[2][i]){
                return field[0][i] == playerSign ? GameStatus.PLAYER_WON : GameStatus.AI_WON;
            }
        }
        if(field[0][0] != '-' && field[0][0] == field[1][1] && field[0][0] == field[2][2]){
            return field[0][0] == playerSign ? GameStatus.PLAYER_WON : GameStatus.AI_WON;
        }
        if(field[0][2] != '-' && field[0][2] == field[1][1] && field[0][2] == field[2][0]){
            return field[0][2] == playerSign ? GameStatus.PLAYER_WON : GameStatus.AI_WON;
        }

        if(turnNumber >= 8){
            return GameStatus.DRAW;
        }
        return GameStatus.IN_PROGRESS;
    }

    private static void showGameResult(GameStatus gameStatus){
        switch (gameStatus){
            case DRAW:
                System.out.println("Draw");
                break;
            case PLAYER_WON:
                System.out.println("Player won");
                break;
            case AI_WON:
                System.out.println("Computer won");
                break;
            default:
        }
    }
}
