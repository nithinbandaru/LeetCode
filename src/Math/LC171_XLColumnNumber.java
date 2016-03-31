package Math;

public class LC171_XLColumnNumber {

	public static void main(String[] args) {

		
		String colName = "AB";
		
		int colNum = getXLColNum(colName);
		System.out.println(colNum);
		
	}

	private static int getXLColNum(String colName) {

		if(colName == null || colName.isEmpty())
		{
			return 0;
		}
		
		int colNum = 0;
		for(int i =0 ; i < colName.length() ; i++)
		{
			char ch = colName.charAt(i);			
			colNum = colNum * 26 + (ch - 'A' + 1);			
		}
		
		return colNum;
	}

}
