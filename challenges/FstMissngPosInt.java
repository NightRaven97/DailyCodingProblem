package hanson;
//#04
/*This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.



A naive method to solve this problem is to search all positive integers, starting from 1 in the given array. We may have to search at most n+1 numbers in the given array. So this solution takes O(n^2) in worst case.

We can use sorting to solve it in lesser time complexity. We can sort the array in O(nLogn) time. Once the array is sorted, then all we need to do is a linear scan of the array. So this approach takes O(nLogn + n) time which is O(nLogn).

We can also use hashing. We can build a hash table of all positive elements in the given array. Once the hash table is built. We can look in the hash table for all positive integers, starting from 1. As soon as we find a number which is not there in hash table, we return it. This approach may take O(n) time on average, but it requires O(n) extra space.


 
 */


/*
 * Following is the two step algorithm.
1) Segregate positive numbers from others i.e., move all non-positive numbers to left side. In the following code, segregate() function does this part.
2) Now we can ignore non-positive elements and consider only the part of array which contains all positive elements.
 We traverse the array containing all positive numbers and to mark presence of an element x,
  we change the sign of value at index x to negative. We traverse the array again and print the first index which has positive value. In the following code,
   findMissingPositive() function does this part. Note that in findMissingPositive, we have subtracted 1 from the values as indexes start from 0 in C.
 */

public class FstMissngPosInt
{

	 
	   
	    /* Utility function that puts all non-positive  
	       (0 and negative) numbers on left side of  
	       arr[] and return count of such numbers */
	    static int segregate (int arr[], int size) 
	    { 
	        int j = 0, i; 
	        for(i = 0; i < size; i++) 
	        { 
	           if (arr[i] <= 0)   
	           { 
	               int temp; 
	               temp = arr[i]; 
	               arr[i] = arr[j]; 
	               arr[j] = temp; 
	               // increment count of non-positive  
	               // integers 
	               j++;   
	           } 
	        } 
	       
	        return j; 
	    } 
	       
	    /* Find the smallest positive missing  
	       number in an array that contains 
	       all positive integers */
	    static int findMissingPositive(int arr[], int size) 
	    { 
	      int i; 
	       
	      // Mark arr[i] as visited by making  
	      // arr[arr[i] - 1] negative. Note that  
	      // 1 is subtracted because index start  
	      // from 0 and positive numbers start from 1 
	      for(i = 0; i < size; i++) 
	      { 
	        int x = Math.abs(arr[i]); 
	        if(x - 1 < size && arr[x - 1] > 0) 
	          arr[x - 1] = -arr[x - 1]; 
	      } 
	       
	      // Return the first index value at which  
	      // is positive 
	      for(i = 0; i < size; i++) 
	        if (arr[i] > 0) 
	          return i+1;  // 1 is added becuase indexes  
	                       // start from 0 
	       
	      return size+1; 
	    } 
	       
	    /* Find the smallest positive missing  
	       number in an array that contains 
	       both positive and negative integers */
	    static int findMissing(int arr[], int size) 
	    { 
	       // First separate positive and  
	       // negative numbers 
	       int shift = segregate (arr, size); 
	       int arr2[] = new int[size-shift]; 
	       int j=0; 
	       for(int i=shift;i<size;i++) 
	           { 
	               arr2[j] = arr[i]; 
	               j++; 
	           }     
	       // Shift the array and call  
	       // findMissingPositive for 
	       // positive part 
	       return findMissingPositive(arr2, j); 
	    } 
	    // main function 
	    public static void main (String[] args)  
	    { 
	        int arr[] = {0, 10, 2, -10, -20}; 
	        int arr_size = arr.length; 
	        int missing = findMissing(arr, arr_size); 
	        System.out.println("The smallest positive missing number is "+  
	                            missing); 
	    } 
	} 


