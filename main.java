package tictactoe;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "_________";
        char[] array = userInput.toCharArray();

        System.out.println("---------");
        System.out.println("| " + array[0] + " " + array[1] + " " + array[2] + " |");
        System.out.println("| " + array[3] + " " + array[4] + " " + array[5] + " |");
        System.out.println("| " + array[6] + " " + array[7] + " " + array[8] + " |");
        System.out.println("---------");



        boolean run = true;
        boolean gameRun = true;
        double oddEven = 2;
        char userLetter;

        while (gameRun) {
            while (run) {
                if (oddEven % 2 == 0) {
                    userLetter = 'X';
                }
                else {
                    userLetter = 'O';
                }
                String coords = isNumber(scanner);
                if (coords != null) {
                    if (isOccupied(coords, array, userLetter) == false) {
                        if (isRange(coords) == true) {
                            System.out.println("---------");
                            System.out.println("| " + array[0] + " " + array[1] + " " + array[2] + " |");
                            System.out.println("| " + array[3] + " " + array[4] + " " + array[5] + " |");
                            System.out.println("| " + array[6] + " " + array[7] + " " + array[8] + " |");
                            System.out.println("---------");
                            if (gameStatus(array) == 1) {
                                System.out.println("X wins");
                                gameRun = false;
                            }
                            else if (gameStatus(array) == 2) {
                                System.out.println("O wins");
                                gameRun = false;
                            }
                            else if (gameStatus(array) == 3) {
                                System.out.println("Draw");
                                gameRun = false;
                            }

                            oddEven++;
                            break;
                        }
                        else {
                            System.out.println("Coordinates should be from 1 to 3!");
                        }
                    }
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }
        }
    }

    public static int gameStatus(char[] array) {
        boolean winner = false;
        boolean check = false;
        boolean xWins = false;
        boolean oWins = false;
        boolean finishedGame = true;
        boolean draw = false;
        char letter = 'X';
        int count = 0;
        int allSpotsFilledCheck = 0;
        String outcome = "";


        while (check == false) {
            if (array[0] == letter && array[1] == letter && array[2] == letter) {
                winner = true;
            }
            if (array[3] == letter && array[4] == letter && array[5] == letter) {
                winner = true;
            }
            if (array[6] == letter && array[7] == letter && array[8] == letter) {
                winner = true;
            }
            if (array[0] == letter && array[3] == letter && array[6] == letter) {
                winner = true;
            }
            if (array[1] == letter && array[4] == letter && array[7] == letter) {
                winner = true;
            }
            if (array[2] == letter && array[5] == letter && array[8] == letter) {
                winner = true;
            }
            if (array[0] == letter && array[4] == letter && array[8] == letter) {
                winner = true;
            }
            if (array[2] == letter && array[4] == letter && array[6] == letter) {
                winner = true;
            }
            if (winner == true && count == 0) {
                xWins = true;
            }
            else if (winner == true && count == 1) {
                oWins = true;
            }
            letter = 'O';
            count += 1;
            winner = false;
            if (count == 2 && xWins == false && oWins == false) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 'X' || array[i] == 'O') {
                        allSpotsFilledCheck += 1;
                        if (allSpotsFilledCheck == 9) {
                            draw = true;
                            outcome = "Draw";
                            return 3;
                        }
                    }
                }
                break;
            }
            else if (count == 2 && xWins == true && oWins == false) {
                outcome = "X wins";
                return 1;
            }
            else if (count == 2 && xWins == false && oWins == true) {
                outcome = "O wins";
                return 2;
            }
            else if (count == 2 && xWins == true && oWins == true) {
                outcome = "Impossible";
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 'X' || array[i] != 'O') {
                finishedGame = false;
            }
        }
        if (finishedGame == false && xWins == false && oWins == false && draw == false) {
            outcome = "Game not finished";
        }
        int xcount = 0;
        int ycount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'X') {
                xcount++;
            }
            else if (array[i] == 'O') {
                ycount++;
            }
        }
        if (Math.abs(xcount - ycount) >= 2) {
            outcome = "Impossible";
            return 0;
        }
        return 0;
    }


    public static boolean isOccupied(String coords, char[] array, char userLetter) {
        int second = coords.charAt(coords.length() - 1);
        int first = coords.charAt(0);


        switch (first) {
            case ('1'):
                if (second == '1') {
                    if (array[6] == '_') {
                        array[6] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                if (second == '2') {
                    if (array[3] == '_') {
                        array[3] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                if (second == '3') {
                    if (array[0] == '_') {
                        array[0] = userLetter;
                        return false;
                    }
                    else {
                        return true;

                    }
                }
            case ('2'):
                if (second == '1') {
                    if (array[7] == '_') {
                        array[7] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                if (second == '2') {
                    if (array[4] == '_') {
                        array[4] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                if (second == '3') {
                    if (array[1] == '_') {
                        array[1] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            case ('3'):
                if (second == '1') {
                    if (array[8] == '_') {
                        array[8] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                if (second == '2') {
                    if (array[5] == '_') {
                        array[5] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                if (second == '3') {
                    if (array[2] == '_') {
                        array[2] = userLetter;
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            default:
                return false;
        }
    }

    public static boolean isRange(String coords) {
        char first = coords.charAt(coords.length() - 1);
        char second = coords.charAt(0);
        if ((first >= '1' && first <= '3') && (second >= '1' && second <= '3')) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String isNumber(Scanner scanner) {
        if (scanner.hasNextInt()) {
            String coords = scanner.nextLine();
            return coords;
        }
        System.out.println("You should enter numbers!");
        scanner.nextLine();
        return null;
    }
}
