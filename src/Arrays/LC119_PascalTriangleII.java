package Arrays;

import java.util.ArrayList;
import java.util.List;


public class LC119_PascalTriangleII {

	public static void main(String[] args) {

		int rowIndex = 3;
		
		List<Integer> pascalRow = printPascalTriangle(rowIndex);
		
		System.out.println(pascalRow);
		
	}

	private static List<Integer> printPascalTriangle(int rowIndex) {
		
		List<Integer> pascalRow = new ArrayList<Integer>(); 
		
		for(int i = 0 ; i <= rowIndex  ; i++)
		{
			pascalRow.add(0,1);
			
			for(int j = 1 ; j < pascalRow.size() - 1 ; j++)
			{
				pascalRow.set(j, pascalRow.get(j) + pascalRow.get(j+1));
			}
			
		}
		
		return pascalRow;
	}

}
