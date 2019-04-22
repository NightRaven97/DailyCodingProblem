package hanson;
/*Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?*/
import java.io.*; 
import java.util.HashSet; 

public class April22 
{
	
	  
	
	    static void printpairs(int arr[],int sum) 
	    {        
	        HashSet<Integer> s = new HashSet<Integer>(); 
	        for (int i=0; i<arr.length; ++i) 
	        { 
	            int temp = sum-arr[i]; 
	  
	            // checking for condition 
	            if (temp>=0 && s.contains(temp)) 
	            { 
	                System.out.println("Pair with given sum " + 
	                                    sum + " is (" + arr[i] + 
	                                    ", "+temp+")"); 
	            } 
	            s.add(arr[i]); 
	        } 
	    } 
	  
	    // Main to test the above function 
	    public static void main (String[] args) 
	    { 
	        int A[] = {10,15,3,7}; 
	        int n = 17; 
	        printpairs(A,  n); 
	    } 
	

}
