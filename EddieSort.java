import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.ArrayList;

class EddieSort {
    private static final String FILE_NAME = "5.txt";
    private static Scanner fileScan;
    
    public static void shuffle(int[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            int toSwap = rand.nextInt(arr.length);
            int temp = arr[toSwap];
            arr[toSwap] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] sort(int[] arr) {
        while (true) {
            shuffle(arr);
            if (Checker.checkResults(arr, false)) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        try {
            fileScan = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("Error - File not found.");
            System.exit(1);
        }
        boolean moreLines = true;
        while (moreLines) {
            try {
                int temp = fileScan.nextInt();
                arrList.add(temp);
            } catch (NoSuchElementException e) {
                moreLines = false;
            } 
        }
        fileScan.close();
        
        int[] arr = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) arr[i] = arrList.get(i);
        
        Timer timer = new Timer();
        
        timer.startTimer();
        arr = sort(arr);
        timer.endTimer();
        
        Checker.checkResults(arr, true);
        System.out.println(timer.getTimeString());
    }
}