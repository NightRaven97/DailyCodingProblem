package handson;

public class LongestPal_day45
{
	static String s="bananasannanab";
	public static int max(int a,int b)// to find maximum of two
	{
		return (a>b)?a:b;
	}
	public static void dispSubstring(int start,int end)// to display part of string from start to end 
	{
		System.out.println("longest substring is:-");
		for(int i=start;i<=end;i++)
		{
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String a[])
	{
		
		
		int arr[][]=new int[s.length()][s.length()];  // a 2d array of nXn size
		for(int i=1;i<s.length();i++) 
		// first we ll find length of longest pal substring	                                       // for filling 0 in the lower half of the array
		for(int j=0;j<s.length()-1;j++)
			arr[i][j]=0;
		
		for(int i=0;i<s.length();i++)                 // for filling 1 in the diagonal of the array
			arr[i][i]=1;
		
		for(int k=1;k<s.length();k++)                 // for filling the uper half of the array
		{	
			int i=0,j=k;
			for(int l=s.length()-k;l>=1;l--)                   // for diagonl movement of the array
			{
				if(s.charAt(i)!=s.charAt(j))
					arr[i][j]=max(arr[i][j-1],arr[i+1][j]);
				else
					arr[i][j]=2+arr[i+1][j-1];
				i++;j++;
				
			}
		}
		System.out.println("Dynamic table developed is:-");;
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<s.length();j++)
				System.out.print(arr[i][j]+",");
		    System.out.println();
		}
		System.out.println("length of longest palindromic substring is= "+arr[0][s.length()-1]);
		// to find the substring
		int i=0,j=s.length()-1,start=0,end=0;
		while(j>=1)                                               // back tracking the table from top 
		{
			if(arr[i+1][j] < arr[i][j] && arr[i][j-1] < arr[i][j])
			{	start=i;
				end=j;
				dispSubstring(start,end);
				break;
			}
			else
			{
				if(arr[i+1][j] == arr[i][j])
					i=i+1;
				if(arr[i][j-1] == arr[i][j])
					j=j-1;
				continue;
			}
		}
	}
	
}
