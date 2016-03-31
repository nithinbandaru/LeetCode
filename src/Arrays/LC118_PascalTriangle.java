package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC118_PascalTriangle {

	public static void main(String[] args) {

		
		int numOfRows = 5;
		
		List<List<Integer>> pascal = pascalTriangle(numOfRows);
		
		for(List<Integer> p : pascal)
		{
			System.out.println(p);
		}
		
	}

	private static List<List<Integer>> pascalTriangle(int numOfRows) {

		List<List<Integer>> allRows = new ArrayList<List<Integer>>();
		
		List<Integer> row = new ArrayList<Integer>();
		
		for(int i = 0 ; i < numOfRows ; i++)
		{
			
			row.add(0 , 1);
			
			for(int j = 1; j < row.size() - 1;j++)
			{
				row.set(j, row.get(j) + row.get(j+1));
			}
			
			allRows.add(new ArrayList<Integer>(row));			
		}
		
		return allRows;
	}

}
