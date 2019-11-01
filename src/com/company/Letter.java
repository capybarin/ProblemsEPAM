package com.company;
import java.util.*;

public class Letter {

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


        //Task 3 "OddNumber"
        int arraySize = rand.nextInt(10)+1;
        int [] array = new int[arraySize];
        int max = array[0];
        System.out.print("Array: ");
        for (int i = 0; i < arraySize; i++) {
            array[i]=rand.nextInt(arraySize);
            System.out.print("["+array[i]+"] ");
        }
        for (int i = 0; i < arraySize; i++) {
            if(array[i] > max && array[i]%2 == 1)
                max=array[i];
        }
        System.out.println("\nMax odd number is: "+max);

        //Task 4 "IdenticalNumbers"
        int [] arr1 = new int[arraySize];
        int [] arr2 = new int[arraySize];
        System.out.print("Array 1: ");
        for (int i = 0; i < arr1.length; i++){
            arr1[i]=rand.nextInt(arraySize);
            System.out.print("["+arr1[i]+"] ");
        }
        System.out.print("\nArray 2: ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=rand.nextInt(arraySize);
            System.out.print("[" + arr2[i] + "] ");
        }
        List<Integer> commonList = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j])
                    commonList.add(arr1[i]);
            }
        }
        HashSet<Integer>set = new HashSet<Integer>(commonList);
        System.out.print("\nCommon numbers: ");
        for (Object ob: set)
            System.out.print(ob+" ");

        //Task
        scanner.close();
    }
}