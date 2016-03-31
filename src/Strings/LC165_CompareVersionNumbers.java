package Strings;

public class LC165_CompareVersionNumbers {

	public static void main(String[] args) {

		String ver1 = "8.3.2";
		String ver2 = "6.3.2.3";
		
		
		int val = compareVersions(ver1 , ver2);
		
		System.out.println(val);
		
	}

	private static int compareVersions(String ver1, String ver2) {

		
		String[] version1 = ver1.split("\\.");
		String[] version2 = ver2.split("\\.");
		
		int maxLength = Math.max(version1.length, version2.length);
		
		for(int i = 0 ; i < maxLength ; i++)
		{
			Integer num1 = (i< version1.length) ? Integer.parseInt(version1[i]) : 0;
			
			Integer num2 = (i< version2.length) ? Integer.parseInt(version2[i]) : 0;
			
			int compare  = num1.compareTo(num2);
			
			if(compare != 0)
			{
				return compare;
			}
		}
		
		return 0;
	}

}
