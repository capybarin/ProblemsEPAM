package com.company;
import java.util.*;

public class Letter {

    private static int[] toFormArray(int minVal, int maxVal, int size){
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = (int)(minVal + Math.random() * maxVal);
        return array;
    }

    private static void print(int[] arr){
        for (int i : arr)
            System.out.print(i + "  ");
        System.out.println();
    }

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
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random rand = new Random();
        int compLetterIndex = rand.nextInt(alphabet.length);
        System.out.println(alphabet[compLetterIndex]);
        System.out.println("Enter the letter: ");
        String userLine = scanner.nextLine();
        String userLineFirstSymbol = String.valueOf(userLine.charAt(0));
        while (true) {
            if (alphabet[compLetterIndex].toLowerCase().equals(userLineFirstSymbol.toLowerCase()))
                break;
            else {
                int index = getIndex(alphabet, userLineFirstSymbol);
                if (index > compLetterIndex)
                    System.out.println("Too high!");
                if (index < compLetterIndex)
                    System.out.println("Too low!");
                userLine = scanner.nextLine();
                userLineFirstSymbol = String.valueOf(userLine.charAt(0));
            }
        }
        System.out.println("Congratulations");


        //Task 2 "Palindrome"
        /*int k;
        for(int i = Integer.MIN_VALUE+1;i < Integer.MAX_VALUE-1;i=i+2){
            String bin = Integer.toBinaryString(i);
            for( k=0; k < bin.length()/2; k++) {
                if (bin.charAt(k) != bin.charAt(bin.length() - k - 1))
                    break;
            }
            if(k == bin.length()/2){
                System.out.println(i+" "+bin);}
        }*/

        //Task 3 "OddNumber"
        int arraySize = rand.nextInt(10) + 1;
        int[] array = new int[arraySize];
        int max = array[0];
        System.out.print("Array: ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(arraySize);
            System.out.print("[" + array[i] + "] ");
        }
        for (int i = 0; i < arraySize; i++) {
            if (array[i] > max && array[i] % 2 == 1)
                max = array[i];
        }
        System.out.println("\nMax odd number is: " + max);

        //Task 4 "IdenticalNumbers"
        int[] arr1 = new int[arraySize];
        int[] arr2 = new int[arraySize];
        System.out.print("Array 1: ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(arraySize);
            System.out.print("[" + arr1[i] + "] ");
        }
        System.out.print("\nArray 2: ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rand.nextInt(arraySize);
            System.out.print("[" + arr2[i] + "] ");
        }
        List<Integer> commonList = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j])
                    commonList.add(arr1[i]);
            }
        }
        HashSet<Integer> set = new HashSet<Integer>(commonList);
        System.out.print("\nCommon numbers: ");
        for (Object ob : set)
            System.out.print(ob + " ");

        System.out.println("\n\n\n");



        //Task 5 "PositiveNumbers"
        final int SIZE_ARRAY = 5;
        int[][] arr = new int[SIZE_ARRAY][SIZE_ARRAY];

        for (int i = 0; i < SIZE_ARRAY; i++)
            arr[i] = toFormArray(-5,15,SIZE_ARRAY);

        System.out.println("\n Before: ");
        for (int i = 0; i < SIZE_ARRAY; i++)
            print(arr[i]);

        int sizeNewArr[] = new int[SIZE_ARRAY];
        int sizeMainArr = 0;
        for (int i = 0; i < SIZE_ARRAY; i++) {
            for (int j = 0; j < SIZE_ARRAY; j++) {
                if(arr[i][j] > 0)
                    sizeNewArr[i]++;
            }
            if(sizeNewArr[i] != 0)
                sizeMainArr++;
        }

        int[][] newArr = new int[sizeMainArr][];

        for (int i = 0, k = 0; (i < SIZE_ARRAY) && (k < sizeMainArr); i++) {
            if(sizeNewArr[i] != 0){
                newArr[k] = new int[sizeNewArr[i]];
                int countNext = 0;
                for (int j = 0; (j < SIZE_ARRAY) && (countNext < sizeNewArr[i]); j++) {
                    if(arr[i][j] > 0){
                        newArr[k][countNext] = arr[i][j];
                        countNext++;
                    }
                }
                k++;
            }
        }

        System.out.println("\n After: ");

        for (int i = 0; i < sizeMainArr; i++)
            print(newArr[i]);

        double maxArithmeticMean = Double.MIN_VALUE;
        int lineNumberMaxArithmeticMean = -1;
        for (int i = 0; i < sizeMainArr; i++) {
            int sumThisRows = 0;
            for (int j = 0; j < newArr[i].length; j++)
                sumThisRows += newArr[i][j];
            if((double)sumThisRows / (double)newArr[i].length > maxArithmeticMean){
                maxArithmeticMean = (double)sumThisRows / newArr[i].length;
                lineNumberMaxArithmeticMean = i;
            }
        }

        System.out.println("\nLine number: " + (lineNumberMaxArithmeticMean + 1));


        //Task 6 "MostCommonSymbol"
        int count[] = new int[256];
        String str = "This is a test string";
        for (int i = 0; i < str.length(); i++)
            count[str.toLowerCase().charAt(i)]++;

        int max_ = 0;
        char result = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (max < count[str.toLowerCase().charAt(i)]) {
                max = count[str.toLowerCase().charAt(i)];
                result = str.charAt(i);
            }
        }
        System.out.println("\n\nMost common symbol is: "+result);
        System.out.println("\n\n\n");


        //Task 7 "Wine Catalog"
        ArrayList<WineCatalog> listOfWine = new ArrayList<>();
        WineCatalog wine1 = new WineCatalog("Test1","Ukraine","16.11.06");
        WineCatalog wine2 = new WineCatalog("Test2","Ukraine","15.04.02");
        WineCatalog wine3 = new WineCatalog("Test3","Ukraine","07.11.15");
        WineCatalog wine4 = new WineCatalog("Test4","Ukraine","12.06.06");
        WineCatalog wine5 = new WineCatalog("Test5","Ukraine","15.12.01");
        listOfWine.add(wine1);
        listOfWine.add(wine2);
        listOfWine.add(wine3);
        listOfWine.add(wine4);
        listOfWine.add(wine5);
        for (WineCatalog wine:listOfWine) {
            System.out.println("Name: "+wine.getWineName()+"\nCountry: "+wine.getCountry()+"\nFull years: "+wine.getYear("19.11.04"));
        }

        //Task 8 "Flowers"

        scanner.close();
    }
}