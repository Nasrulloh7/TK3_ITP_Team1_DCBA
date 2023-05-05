/**
 * Introduction to Programming
 * @author                        Team1 - DCBA
 *         Aldo Sunan Fudia		-   2602233260
 *         M. Ilmi Nasrulloh            -   2602233235
 *         Muliando Marpaung	        -   2602233393
 *         Nurul Amalia                 -   2602243993
 *         Saur Parlindungan Situmeang	-   2602239056
 */


import java.util.Scanner;


public class WordPuzzle {

    public static void main(String[] args) {
        
        // Soal Level 1
        String[] soalLevel1 = {"d", "e", "t", "t", "l", "i"};
        
        // Soal Level 2
        String[] soalLevel2 = {"s", "e", "c", "a", "e", "n"};
        
        // Soal Level 3
        String[] soalLevel3 = {"h", "k", "r", "n", "e", "o"};
        
        // Kunci Level 1
        String[] kunciLevel1 = {"die", "led", "let", "lid", "lie", "lit", 
                                "tie", "deli", "diet", "edit", "idle", "tide", 
                                "tell", "tile", "tilt", "tilde", "title", "delete"
                               };

        // Kunci Level 2
        String[] kunciLevel2 = {"scan", "case", "scene", "can", "seen",
                                "sea", "see", "cease", "cane", "sec",
                                };
        
        // Kunci Level 3 
        String[] kunciLevel3 = {"ore", "honk", "her", "hen", "roe", "honker",
                                "neo", "one", "hoe", "hone", "hero", "hore"
                               };

        // Variabel input
        String repetisi;
        boolean val_repetisi = false;
        boolean val_stop = false;
        int minLengthAnswer = 3, maxLengthAnswer = 6;
        Scanner input = new Scanner(System.in);
        
        do {
            // Variabel Level 1
            String[] jawabanLv1 = new String[10];
            int jml_jawaban_lv1 = 1;
            int idx_jawaban_lv1 = 0;
            int jml_jawaban_betul_lv1 = 0;
            int score_lv1 = 0;
            
            // Variabel Level 2
            String[] jawabanLv2 = new String[10];
            int jml_jawaban_lv2 = 1;
            int idx_jawaban_lv2 = 0;
            int jml_jawaban_betul_lv2 = 0;
            int score_lv2 = 0;
            
            // Variabel Level 3
            String[] jawabanLv3 = new String[10];
            int jml_jawaban_lv3 = 1;
            int idx_jawaban_lv3 = 0;
            int jml_jawaban_betul_lv3 = 0;
            int score_lv3 = 0;
            int score_all = 0;

            // Output layar awal program
            System.out.println("Coepoe Word Puzzle");
            System.out.println("==================");

            System.out.println("Rules:");
            System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters");
            System.out.println("2. Each level, You have 10 chances to answer correctly.");
            System.out.println("3. To get through to next level, you have to score 70 each level.");
            System.out.println("\n");

            do {
                // Output Level 1
                System.out.println("Level 1");
                System.out.println("-------");

                System.out.print("\t\t");
                printArray(soalLevel1);
            
                do {
                    boolean answer_valid = false;
                    do {
                        String temp_jawaban;
                        System.out.print(jml_jawaban_lv1 + "> Your Answer : ");
                        temp_jawaban = input.next();
                        if (temp_jawaban.length() <= maxLengthAnswer && temp_jawaban.length() >= minLengthAnswer) {
                            if (idx_jawaban_lv1 > 0) {
                                int hasilLinearSearch = linearSearch(jawabanLv1, temp_jawaban);
                                if (hasilLinearSearch == 1) {
                                    System.out.println("You had already type this word before..");
                                } else {
                                    answer_valid = true;
                                    jawabanLv1[idx_jawaban_lv1] = temp_jawaban;
                                    int hasilBandingJawabanLv1 = linearSearch(kunciLevel1, jawabanLv1[idx_jawaban_lv1]);
                                    if (hasilBandingJawabanLv1 == 1) {
                                        score_lv1 += 10;
                                        jml_jawaban_betul_lv1 += 1;
                                        System.out.println("#Right. Score : " + score_lv1);
                                    }
                                }
                            } else {
                                answer_valid = true;
                                jawabanLv1[idx_jawaban_lv1] = temp_jawaban;
                                int hasilBandingJawabanLv1 = linearSearch(kunciLevel1, jawabanLv1[idx_jawaban_lv1]);
                                if (hasilBandingJawabanLv1 == 1) {
                                    score_lv1 += 10;
                                    jml_jawaban_betul_lv1 += 1;
                                    System.out.println("#Right. Score : " + score_lv1);
                                }
                            }
                        } else {
                            System.out.println("min 3 characters & max 6 characters");
                        }                
                    
                    } while (!answer_valid);
                        idx_jawaban_lv1++;
                        jml_jawaban_lv1++;
                    
                } while (jml_jawaban_lv1 <= 10);
                    System.out.println("You had answered 10 times with " + jml_jawaban_betul_lv1 + " right answers..\n");
                
                // Output ketika user gagal
                if (score_lv1 < 70) {
                    System.out.println("Your score : " + score_lv1);
                    System.out.print("You Lose!! Try again.. \n" + "Do you want to retry [y/t]? ");
                    repetisi = input.next();
                    if (repetisi.equals("Y") || repetisi.equals("y")) {
                        val_repetisi = true;
                        jawabanLv1 = new String[10];
                        jml_jawaban_lv1 = 1;
                        idx_jawaban_lv1 = 0;
                        jml_jawaban_betul_lv1 = 0;
                        score_lv1 = 0;
                        System.out.println("\n");
                    } else {
                        System.exit(0);
                    }
                // Output ketika user berhasil
                } else {
                    // Print kunci jawaban
                    System.out.println("Correct Answers : ");
                    printArray(kunciLevel1);
                    val_repetisi = false;
                }
            }while(val_repetisi);

            do{
                // Output LEVEL 2
                System.out.println("\n");
                System.out.println("Level 2");
                System.out.println("-------");

                System.out.print("\t\t");
                printArray(soalLevel2);

                do {
                    boolean answer_valid = false;
                    do {
                        String temp_jawaban;
                        System.out.print(jml_jawaban_lv2 + "> Your Answer : ");
                        temp_jawaban = input.next();
                        if (temp_jawaban.length() <= maxLengthAnswer && temp_jawaban.length() >= minLengthAnswer) {
                            if (idx_jawaban_lv2 > 0) {
                                int hasilLinearSearch = linearSearch(jawabanLv2, temp_jawaban);
                                if (hasilLinearSearch == 1) {
                                    System.out.println("You had already type this word before..");
                                } else {
                                    answer_valid = true;
                                    jawabanLv2[idx_jawaban_lv2] = temp_jawaban;
                                    int hasilBandingJawabanLv2 = linearSearch(kunciLevel2, jawabanLv2[idx_jawaban_lv2]);
                                    if (hasilBandingJawabanLv2 == 1) {
                                        score_lv2 += 10;
                                        jml_jawaban_betul_lv2 += 1;
                                        System.out.println("#Right. Score : " + score_lv2);
                                    }
                                }
                            } else {
                                answer_valid = true;
                                jawabanLv2[idx_jawaban_lv2] = temp_jawaban;
                                int hasilBandingJawabanLv2 = linearSearch(kunciLevel2, jawabanLv2[idx_jawaban_lv2]);
                                if (hasilBandingJawabanLv2 == 1) {
                                    score_lv2 += 10;
                                    jml_jawaban_betul_lv2 += 1;
                                    System.out.println("#Right. Score : " + score_lv2);
                                }
                            }
                        } else {
                            System.out.println("min 3 characters & max 6 characters");
                        }

                    } while (!answer_valid);
                        idx_jawaban_lv2++;
                        jml_jawaban_lv2++;
                    
                } while (jml_jawaban_lv2 <= 10);
                    System.out.println("You had answered 10 times with " + jml_jawaban_betul_lv2 + " right answers..\n");

                // Output ketika user gagal
                if (score_lv2 < 70) {
                    System.out.println("Your score : " + score_lv2);
                    System.out.print("You Lose!! Try again.. \n" + "Do you want to retry [y/t]? ");
                    repetisi = input.next();
                    if (repetisi.equals("Y") || repetisi.equals("y")) {
                        val_repetisi = true;
                        jawabanLv2 = new String[10];
                        jml_jawaban_lv2 = 1;
                        idx_jawaban_lv2 = 0;
                        jml_jawaban_betul_lv2 = 0;
                        score_lv2 = 0;
                    } else {
                        System.exit(0);
                    }
                // Output ketika user berhasil
                } else {
                    // Print kunci jawaban
                    System.out.println("Correct Answers : ");
                    printArray(kunciLevel2);
                    val_repetisi = false;
                }
            }while(val_repetisi);
            
            do{
                // Output LEVEL 3
                System.out.println("\n\n");
                System.out.println("Level 3");
                System.out.println("-------");

                System.out.print("\t\t");
                printArray(soalLevel3);

                do {
                    boolean answer_valid = false;
                    do {
                        String temp_jawaban;
                        System.out.print(jml_jawaban_lv3 + "> Your Answer : ");
                        temp_jawaban = input.next();
                        if (temp_jawaban.length() <= maxLengthAnswer && temp_jawaban.length() >= minLengthAnswer) {
                            if (idx_jawaban_lv3 > 0) {
                                int hasilLinearSearch = linearSearch(jawabanLv3, temp_jawaban);
                                if (hasilLinearSearch == 1) {
                                    System.out.println("You had already type this word before..");
                                } else {
                                    answer_valid = true;
                                    jawabanLv3[idx_jawaban_lv3] = temp_jawaban;
                                    int hasilBandingJawabanLv3 = linearSearch(kunciLevel3, jawabanLv3[idx_jawaban_lv3]);
                                    if (hasilBandingJawabanLv3 == 1) {
                                        score_lv3 += 10;
                                        jml_jawaban_betul_lv3 += + 1;
                                        System.out.println("#Right. Score : " + score_lv3);
                                    }
                                }
                            } else {
                                answer_valid = true;
                                jawabanLv3[idx_jawaban_lv3] = temp_jawaban;
                                int hasilBandingJawabanLv3 = linearSearch(kunciLevel3, jawabanLv3[idx_jawaban_lv3]);
                                if (hasilBandingJawabanLv3 == 1) {
                                    score_lv3 += 10;
                                    jml_jawaban_betul_lv3 += 1;
                                    System.out.println("#Right. Score : " + score_lv3);
                                }
                            }

                        } else {
                            System.out.println("min 3 characters & max 6 characters");
                        }

                    } while (!answer_valid);
                        idx_jawaban_lv3++;
                        jml_jawaban_lv3++;
                    
                } while (jml_jawaban_lv3 <= 10);
                    System.out.println("You had answered 10 times with " + jml_jawaban_betul_lv3 + " right answers..\n");
                
                // Output ketika user gagal
                if (score_lv3 < 70) {
                    System.out.println("Your score : " + score_lv3);
                    System.out.print("You Lose!! Try again.. \n" + "Do you want to retry [y/t]? ");
                    repetisi = input.next();
                    if (repetisi.equals("Y") || repetisi.equals("y")) {
                        val_repetisi = true;
                        jawabanLv3 = new String[10];
                        jml_jawaban_lv3 = 1;
                        idx_jawaban_lv3 = 0;
                        jml_jawaban_betul_lv3 = 0;
                        score_lv3 = 0;
                    } else {
                        System.exit(0);
                    }
                }
                // Output ketika user berhasil
                else {
                    // Print kunci jawaban
                    System.out.println("Correct Answers : ");
                    printArray(kunciLevel3);
                    val_repetisi = false;
                    
                    // Output score akhir
                    score_all = score_lv1 + score_lv2 + score_lv3;
                    System.out.println("\n");
                    System.out.println("Overall Score : " + score_all);
                    
                    input.nextLine();
                    System.out.print("You Win!! \nPress ENTER to exit..");
                    input.nextLine();
                    val_stop = true;
                }
            }while(val_repetisi);

        } while (!val_stop);
    }

    public static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null ? key == null : arr[i].equals(key)) {
                return 1;
            }
        }
        return 0;
    }

    public static void printArray(String[] arr) {
        int word_printed = 1;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            word_printed++;
            if (word_printed == 7) {
                System.out.print("\n");
                word_printed = 1;
            }
        }
    }
}