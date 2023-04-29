/**
 * Introduction to Programming
 * @author                        Team1 - DCBA
 *         Aldo Sunan Fudia		-   2602233260
 *         M. Ilmi Nasrulloh		-   2602233235
 *         Muliando Marpaung		-   2602233393
 *         Nurul Amalia			-   2602243993
 *         Saur Parlindungan Situmeang	-   2602239056
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordPuzzle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("COEPOE WORD PUZZLE");
        System.out.println("=================== \n");
        System.out.println("Rules :");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters");
        System.out.println("2. Each level, you have 10 chances to answer correctly");
        System.out.println("3. To get through to next level, you have to score 70 Points each level");
        System.out.println("\n");

        String[][] words = {
            {"d", "e", "t", "t", "l", "i"},
            {"s", "e", "c", "a", "e", "n"},
            {"h", "k", "r", "n", "e", "o"}
        };
        ArrayList<String> usedWords = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            System.out.println("LEVEL " + (i + 1));
            System.out.println("-------");
            
            ArrayList<String> letters = new ArrayList<String>(Arrays.asList(words[i]));
            Collections.shuffle(letters);
            System.out.println("\t\t" + String.join("    ", letters));
            
            for (int j = 1; j <= 10; j++) {
                System.out.print(j+"> Your Answer : ");
                String answer = scanner.nextLine().toLowerCase();
                if (answer.length() < 3 || answer.length() > 6) {
                    System.out.println("min 3 characters & max 6 characters");
                    j--;
                } else if (!Arrays.asList(words[i]).containsAll(Arrays.asList(answer.split("")))) {
                    System.out.println("Answers can't contain any letters other than the ones provided");
                    j--;
                }
                System.out.println();
            }
        }
    }
}


