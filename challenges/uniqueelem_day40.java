package handson;
/*
 * This problem was asked by Google.

Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
 */

public class uniqueelem_day40
{
	public static void main(String a[])
	{   int arr[]= {6,1,3,3,3,6,6};
		int largest=0;
		for(int i=0;i<arr.length;i++)//to find the size of hash table
		{
			largest=(largest>arr[i])?largest:arr[i];
		}
		int hash[]=new int[largest+1];//creating hash table of ssize of largest element of array
		
		for(int i=0;i<arr.length;i++)//increasing the count of each element in the given array
		{
			hash[arr[i]]++;
		}
		for(int i=0;i<hash.length;i++)
		{
			if(hash[i]==1)//if count is 1
				{
					System.out.println(hash[i]);
					break;
				}
			 
		}
	}
}
