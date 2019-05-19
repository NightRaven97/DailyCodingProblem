package handson;

public class DCP27braces 
{
	char[] stac=new char[10];
	int top=-1;
	void push(char ch)
	{
		stac[++top]=ch;
	}
	char pop()
	{
		return stac[top--];
	}	
	public static void main(String ag[])
	{	char res='a';
		int flag=1;
		DCP27braces ob=new DCP27braces();
		String s="[{[]}]{}";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
				ob.push(s.charAt(i));
			
			else if(s.charAt(i)=='}' || s.charAt(i)==')' || s.charAt(i)==']')
			{
				res=ob.pop();
			
			
				if ((s.charAt(i)=='}' && res != '{')||( s.charAt(i)==']' && res !='[')||( s.charAt(i)==')'&& res !='('))
				{
					flag=0;
				}
			}
			
		}
		if( flag ==0)
			System.out.println("no");
		else
		    System.out.print("es");
	}

}
