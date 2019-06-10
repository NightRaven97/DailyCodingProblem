package handson;
/*
 * This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */

public class MaxConti_day49
{
	public static int  max(int a,int b)
	{
		return (a>b)?a:b;
	}
	public static void eval(int array[])
	{   int sum=0;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<0)
				sum=max(sum+array[i],0);
			else
				sum=sum+array[i];
			
		}
		System.out.println("required sum is "+sum);
	}
	public static void main(String a[])
	{
		
		int arr1[]= {34,-50,42,14,-5,86};
		int arr2[]= {-5,-1,-8,-9};
		eval(arr1);
		eval(arr2);
		
	}

}
