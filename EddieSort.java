import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.ArrayList;

class EddieSort {
    private static final String FILE_NAME = "5000_source.txt";
    private static Scanner fileScan;
    
    /**
     * Creates a deep copy of an integer array
     * 
     * @param oldArr The array to be cloned
     * @return A deep copy of oldArr
     */
    private static int[] cloneArr(int[] oldArr) {
        int[] arr = new int[oldArr.length];
        for (int i = 0; i < arr.length; i++) arr[i] = oldArr[i]; // Loop through original array and copy data over
        return arr;
    }

    /**
     * My sorting method.
     * I think it's merge sort, but I recreated it from memory.
     * 
     * @param oldArr The array to be sorted
     * @return The sorted version of oldArr
     */
    private static int[] eddieSort(int[] oldArr) {
        int[] arr = cloneArr(oldArr);
        
        // Base case
        if (arr.length == 1) return arr;
        
        // Create copies of left and right half of array
        int m = arr.length / 2;
        int[] leftArr = new int[m];
        for (int i = 0; i < leftArr.length; i++) leftArr[i] = arr[i];
        int[] rightArr = new int[arr.length - m];
        for (int i = 0; i < rightArr.length; i++) rightArr[i] = arr[m + i];
        
        // Sort left and right halves recursively
        leftArr = eddieSort(leftArr);
        rightArr = eddieSort(rightArr);
        
        // Combine left and right halves
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (l < leftArr.length && (r == rightArr.length || leftArr[l] < rightArr[r])){
                arr[i] = rightArr[l];
                l++;
            } else if (r < rightArr.length && (l == leftArr.length || rightArr[r] < leftArr[l])){
                arr[i] = rightArr[r];
                r++;
            }
        }
        
        return arr;
    }

    public static void main(String[] args) {
        // Initialize file scanner
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        try {
            fileScan = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e) {
            System.out.println("Error - File not found.");
            System.exit(1);
        }
        
        // Get arraylist of all lines in the text file
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
        
        // Transfer integers to a regular array
        int[] arr = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) arr[i] = arrList.get(i);
        
        Timer timer = new Timer();
        
        // Sort the array with eddieSort and time it
        timer.startTimer();
        arr = eddieSort(arr);
        timer.endTimer();
        
        // Display results
        Checker.checkResults(arr, true);
        System.out.println("Took " + timer.getTimeString() + " to sort " + arr.length + " values");
    }
}