
public class Checker
{
 /**
     * Sort result checker.
     * 
     * This modular method will check any given array of integers and 
     * return true if the values are correctly sorted or false if there
     * are any errors. Setting the parameter boolean reporting to true
     * will also output the results to the screen.
     * 
     * @param theArray  The array of integers that you want to check
     * @param report    True if you want results displayed to the screen
     * @return boolean  True if the values are in numerical order
     * 
     * @author Jordan Cohen
     * @version April 2014
     */
    public static boolean checkResults (int[] theArray, boolean report)
    {
        System.out.println("Checking Validity");
        boolean stillValid = true;
        int counter = 0;
        while (stillValid && counter < theArray.length - 1)
        {
            if (theArray[counter] > theArray[counter + 1])
            {
                stillValid = false;
            }
            counter++;
        }
        if (report)
        {
            if (stillValid)
            {
                System.out.println("Checked " + theArray.length + " values. Sort is valid");
            }
            else
            {
                System.out.println("Checked " + theArray.length + " values. Found error at " + counter);
            }
        }

        return stillValid;
    }
}
