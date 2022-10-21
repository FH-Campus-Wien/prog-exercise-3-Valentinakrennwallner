package at.ac.fhcampuswien;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class App {


    public static void oneMonthCalendar (int numberDay, int startingDay){
        int line;
        int row = 0;
        if(startingDay!=1){
            for (int j = 1; j < startingDay; j++)
                System.out.print("   ");
        }
        line = startingDay - 1;
        for (int i = 1; i <= numberDay; i++){
            line++;
            row++;
            if(row < 10)
                System.out.print(" " + row + " ");
            else
                System.out.print(row + " ");
            if(line==7 && row != numberDay){
                line = 0;
                System.out.println();
            }
        }
        System.out.println();
    }


    public static long @NotNull [] lcg(long Seed) {
        long m = (long) Math.pow(2, 31);
        int a = 1103515245, c = 12345;
        long[] solution = new long[10];
        solution[0] = (a * Seed + c) % m;
        for (int x = 1; x < solution.length; x++) {
            solution[x] = (a * solution[x - 1] + c) % m;

        }


        return solution;
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random random = new Random();
        int number = random.nextInt(100)+1;
        return number;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scan1 = new Scanner(System.in);
        int guess, i;
        for (i = 1; i <= 10; i++) {
            System.out.print("Guess number " + i + ": ");
            guess = scan1.nextInt();

            if (guess == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
            if (i == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            if (guess > numberToGuess) System.out.println("The number AI picked is lower than your guess.");
            if (guess < numberToGuess) System.out.println("The number AI picked is higher than your guess.");
        }
    }

    public static boolean swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        int temp;
        for (int l = 0; l < arr1.length; l++) {
            temp = arr1[l];
            arr1[l] = arr2[l];
            arr2[l] = temp;
        }
        return true;
    }

    public static String camelCase(String input){
        char[] cc = input.toCharArray();
        String output, nextoutput, result;
        for(int j = 0; j < cc.length; j++){
            if(j==0){
                if((int)cc[j] >= 97 && (int)cc[j] <= 122) {
                    cc[j] = (char) ((int) cc[j] - 32);
                }
            }
            else{
                if((int)cc[j] >= 65 && (int)cc[j] <= 90 && (int)cc[j-1] != 32) {
                    cc[j] = (char) ((int) cc[j] + 32);
                }
                else if((int)cc[j] >= 97 && (int)cc[j] <= 122 && (int)cc[j-1] == 32) {
                    cc[j] = (char) ((int) cc[j] - 32);
                }
            }
        }
        output = String.valueOf(cc);
        nextoutput = output.replace("!","");
        char[] interim = nextoutput.toCharArray();

        for(int j = 0; j < interim.length; j++){
            if(((int)interim[j]<97 && (int)interim[j]>90) || ((int)interim[j]<65 || (int)interim[j]>122)){
                interim[j]=(char)33;
            }
        }

        nextoutput = String.valueOf(interim);
        result =nextoutput.replace("!","");
        System.out.println(result);
        return result;
    }


    public static int checkDigit(int[] code) {
        int[] gewichtung = new int[code.length];
        for (int j = 0; j < code.length; j++) {
            gewichtung[j] = j + 2;
        }
        int[] produkt = new int[code.length];
        int sum = 0;
        for (int n = 0; n < code.length; n++) {
            produkt[n] = gewichtung[n] * code[n];
            sum += produkt[n];
        }
        double rest = sum % 11;

        if (11 - rest == 10) {
            return 0;
        }
        if (11 - rest == 11) {
            return 5;
        }
        return (int) (11 - rest);
    }
}
