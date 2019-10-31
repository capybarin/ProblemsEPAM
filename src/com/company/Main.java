package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int getIndex(String[] array, String symbol){
        int index=0;
        for (int i = 0; i <array.length ; i++) {
            if(array[i].toLowerCase().equals(symbol.toLowerCase())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        //Task 1 "Letter"
        Scanner scanner = new Scanner(System.in);
	    String[] alphabet ={"a","b","c","d","e","f","g","h","i","j","k","l","m",
                            "n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random rand = new Random();
        int compLetterIndex = rand.nextInt(alphabet.length);
        System.out.println(alphabet[compLetterIndex]);
        System.out.println("Enter the letter: ");
        String userLine = scanner.nextLine();
        String userLineFirstSymbol = String.valueOf(userLine.charAt(0));
        while(true) {
            if (alphabet[compLetterIndex].toLowerCase().equals(userLineFirstSymbol.toLowerCase()))
                break;
            else {
                int index = getIndex(alphabet,userLineFirstSymbol);
                if (index > compLetterIndex)
                    System.out.println("Too high!");
                if (index < compLetterIndex)
                    System.out.println("Too low!");
                userLine = scanner.nextLine();
                userLineFirstSymbol = String.valueOf(userLine.charAt(0));
            }
        }
        System.out.println("Congratulations");

    }
}
