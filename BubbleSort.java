/**
 * <pre>
 * 
 * Author:
 *  	Brandon Mota 
 *  
 *  
 * Description: 
 * 		This program will sort a given set of data
 * 		from a text file using the bubble sort method.
 * 
 * 
 * </pre>
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BubbleSort 
{
	private int[] arr;
	private int compare;
	
	/**
	 * <pre>
	 * Description: 
	 * This is the constructor for the class.
	 * Pre:
	 * none. 
	 * Post:
	 * Sets the size of the new array.
	 * </pre>
	 * 
	 */
	public BubbleSort()
	{
		arr = new int[20];
		compare = 0;
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This sorts the array using the bubble method.
	 * Pre:
	 * none. 
	 * Post:
	 * The array is sorted.
	 * </pre>
	 * 
	 */
	public void bubble()
	{
		int temp;
		for (int i = 0; i < arraycount(); i++)
		{
			for (int j = 0; j < arraycount()-1; j++)
			{
				compare++;
				if( arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This prints the array.
	 * Pre:
	 * The array must not be all 0s. 
	 * Post:
	 * The array is printed.
	 * </pre>
	 * 
	 */
	public void arrayprint()
	{
		for (int i = 0; i < 20; i++)
		{
			if (arr[i] != 0)
			{
			System.out.print(arr[i]);			
			System.out.print("  ");
			}
		}
	}
	
	/**
	 * <pre>
	 * Description: 
	 * This "shortens" the array size when the 20 indexes of the array
	 * are not filled since an integer array fills empty spaces
	 * with 0s thus making the program do more compares than necessary.
	 * Pre:
	 * Array must not be all 0s. 
	 * Post:
	 * The "true" array size is returned.
	 * </pre>
	 * 
	 */	
	public int arraycount()
	{
		for (int i = 0; i < 20; i++)
		{
			if (arr[i] == 0)
			{
				return i;
			}
		}
		return arr.length;
	}

	/**
	 * <pre>
	 * Description: 
	 * This is the main method that controls the flow
	 * of the program.
	 * </pre>
	 * 
	 */
	public static void main(String[] args)
	{
		BubbleSort sort = new BubbleSort();
		int i = 0;
		
		try
		{		
			File file = new File("data2.txt");		
			Scanner scan = new Scanner(file);		
			while (scan.hasNext())		
			{
				sort.arr[i] = scan.nextInt();
				i++;
			}
			System.out.println("The array looks like this:");
			sort.arrayprint();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
			System.out.println("Ensure that data2.txt is present and in the correct location.");
			System.out.println("Program Terminated......");
		}
		
		sort.bubble();
		System.out.println("\nThe sorted array looks like this:");
		sort.arrayprint();
		System.out.println("\nNumber of compares: " + sort.compare);

	}

}

