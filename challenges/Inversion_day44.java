package handson;


/* Java program for Merge Sort */
class MergeSort 
{ 
	static int finalSum=0;//stores the number of inversion 
	public static void mergeSort(int[] a, int n) {
	    if (n < 2)
	    {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	
	    }
	public static void merge(int[] a, int[] l, int[] r, int left, int right) 
	{
			    int sum=0;//count the no. of inversions in each merge of the arrays
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] <= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			        	sum+=left-i;//increase the count if elem from 2nd array if placed fst to elem from from fst array 
			            a[k++] = r[j++];//increases by the no. of element left in 1st array
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			        
			    }
			    finalSum+=sum;
	}
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	public static void main(String a[])
	{
	    int[] actual = { 2,4,1,3,5 };
	    System.out.println("Given Array"); 
        printArray(actual); 
  
	    
	    MergeSort.mergeSort(actual, actual.length);
	   
  
       
  
        System.out.println("\nSorted array"); 
        printArray(actual); 
        System.out.println(finalSum); 
	    
	}
} 


