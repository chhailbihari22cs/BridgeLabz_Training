import java.util.*;
public class mergedSort
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the length of an array");
	int length=sc.nextInt();
	int [] arr = new int[length];//here we declear an array
	
	
	//here we initialize an array
	System.out.println("please enter book prices");
	for(int i=0;i<length;i++)
	{
	    arr[i]=sc.nextInt();
	}
	System.out.println("\n Array before sorting technique ");
	display(arr);
	int[]finalAnswer=ans(arr,0,arr.length-1);
	System.out.println("\n Array after sorting technique");
	display(finalAnswer);
	}
	
	
	
	//its a merge sort technique----------------------------
	
	public static int[] ans(int[]arr,int si,int ei)
	{
	    //here we implement base case :
	    if(si==ei)
	    {
	        int[]single=new int[1];
	        single[0]=arr[si];
	        return single;
	    }
	    int mid=(si+ei)/2;
	    int[]fa=ans(arr,si,mid);
	    int[]sa=ans(arr,mid+1,ei);
	    return merge(fa,sa);
	        
	}
	
	
	//here we merge two sorted array-----------------
	
	public static int[] merge(int[]fa,int[]sa)
	{
	    int n=fa.length;
	    int m=sa.length;
	    int [] mergedArray= new int [n+m];
	    int i=0;
	    int j=0;
	    int k=0;
	    while(i<n&&j<m)
	    {
	        if(fa[i]>sa[j])
	        {
	            mergedArray[k]=sa[j];
	            j++;
	            k++;
	        }
	        else{
	            mergedArray[k]=fa[i];
	            i++;
	            k++;
	        }
	    }
	    while(i<n)
	    {
	        mergedArray[k]=fa[i];
	        i++;
	        k++;
	    }
	    while(j<m)
	    {
	        mergedArray[k]=sa[j];
	        k++;
	        j++;
	    }
	    return mergedArray;
	}
	
	
	public static void display(int[]arr)
	{
	    for(int i=0;i<arr.length;i++)
	    {
   	    System.out.print(arr[i]+"\t");
	    }
	}
}