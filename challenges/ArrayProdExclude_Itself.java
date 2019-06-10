package hanson;
/* #02
  This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division? */

//import java.io.*;
/*using division tech , we can solve this in O(n) time.
we cannot use division technique.. */

public class ArrayProdExclude_Itself
{
	static int[] res_arr=new int[100];
	
	
	static void calc(int arr[],int n)
	{
		int prod=1;
		for (int i=0;i<n;i++)
		{	
			prod=1;
			for(int j=0;j<n;j++)
			{
				if(!(i==j))
				{
					prod*=arr[j];
				}
				
			}
			res_arr[i]=prod;
		}
    }
	
	public static void main(String arg[])
	{
		int[] arry= {2,3,4};
		calc(arry,3);
		for(int i=0;i<arry.length;i++)
		{
			System.out.print(res_arr[i]+",");
		}
	}
		
}
