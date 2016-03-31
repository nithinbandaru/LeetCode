package Math;

public class LC168_ConvertToXLTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int column = 52;
		
		String colName = getXLTitle(column);

		System.out.println("Column Name: " + colName);
	}

	private static String getXLTitle(int colNo) {

		StringBuilder colName = new StringBuilder();
		
		while(colNo > 0)
		{
			colNo--;			
			colName.insert(0, (char)('A' + colNo % 26));
			colNo = colNo/26;			
		}
		
		return colName.toString();
	}

}
