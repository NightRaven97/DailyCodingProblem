package handson;
/* This problem was asked by Facebook.

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', 
you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.
 
 */

public class Itinerary_day41 
{
		
		public static String hashe[][]= {{"a","b"},{"a","c"},{"b","c",},{"c","a"}};
		public static int vis[]= {0,0,0,0};	
		public static int count=0;
	    public static void main(String a[])
		{
			String toSearch="a";
			int j=0;
			System.out.print(toSearch+",");
				while(count !=4)//no. of flights. here its=4				
				{  
					if(toSearch.equals(hashe[j][0])&&vis[j]==0)//to match the origin flight and ensure its not taken again since there there is different origin from same destination, so if ignored can be mistakenly taken as cycle
					{   count++;
						vis[j]=1;
						System.out.print(hashe[j][1]+",");
						toSearch=hashe[j][1];
						j=0;
					}
					else 
					{ 
						j++;
					}
				}
				
			}
		}
		


