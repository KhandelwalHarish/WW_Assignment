package test;
import java.util.Arrays;
import java.util.Random;


public class findSmallestNumber {
	
	public static void main(String[] args)
	{
		
		 int[] randomNumbers = new int[500]; // Create array object.
		 
	        random(randomNumbers); // Create random numbers.
	        
	        //using the predefined sort method
	        Arrays.sort(randomNumbers);
	        
	        
	        //Printing the 10th smallest number
	        System.out.println(findNthSmallestNumber(10, randomNumbers));
	}
	
	/** random number find method */
    public static void random(int[] arraylist){
        for(int i=0; i < arraylist.length; i++){
            arraylist[i]    = (int) (Math.random() * 1000);  
        }
    } 
    // End of random method.
   
/** find nth smallest method. */
    public static int findNthSmallestNumber(int n, int[] numbers){
        return numbers[n-1];
    } // End of findNthSmallesNumber method.
}
