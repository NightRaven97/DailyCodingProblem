package handson;
/* This problem was asked by Google.

Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
*/


public class SmSubSet
{
	//int[] x=new int[4];int m;
	int[] x= {0,0,0,0,0,0};
	int[] w= {1,2,5,9,12,61};
	int m=24;
	public void disp(int[] ar)
	{
		for (int i = 0; i <w.length; i++)
		{
			if(ar[i]==1)
				System.out.print(w[i]+",");
		}
		System.out.println();
	}
		
	public void sos(int s,int k,int r)
	{	
		x[k]=1;
		if(s+w[k]==m)
			disp(x);
		
		else if(s+w[k]+w[k+1]<=m)
			sos(s+w[k],k+1,r-w[k]);
		
		if((s+r-w[k]>=m)&&(s+w[k+1]<=m))
		{
			x[k]=0;
			sos(s,k+1,r-w[k]);
		}
		
		
	}
	public static void main(String arg[])
	{
		SmSubSet s=new SmSubSet();
		
		s.sos(0,0,90);
	}

}
