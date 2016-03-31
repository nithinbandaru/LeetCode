package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC093_RestoreValidIPAddress {

	public static void main(String[] args) {

		String ipAddress = "25525511135";
		
		List<String> ipAddressList = restoreIPAddresses(ipAddress);
		
		for(String ip : ipAddressList)
		{
			System.out.println(ip);
		}
	}

	private static List<String> restoreIPAddresses(String ipAddress) {

		List<String> result = new ArrayList<String>();
		
		int len = ipAddress.length();
		
		for(int i = 1 ; i < 4 && i < len-2; i++)
		{
			for(int j = i+1 ; j < i+4 && j < len-1; j++)
			{
				for(int k = j+1; k < j+4 && k < len ; k++)
				{
					String s1 = ipAddress.substring(0,i);
					String s2 = ipAddress.substring(i,j);
					String s3 = ipAddress.substring(j,k);
					String s4 = ipAddress.substring(k,len);
					System.out.println(s1+"."+s2+"."+s3+"."+s4);
					if(IsValid(s1) && IsValid(s2) && IsValid(s3) && IsValid(s4))
					{
						result.add(s1+"."+s2+"."+s3+"."+s4);
					}
				}
			}
		}
		
		return result;
	}

	private static boolean IsValid(String s) {

		if(s.length() > 3 || s.length() == 0 || (s.length() > 1 && s.charAt(0) == '0') || Integer.parseInt(s) > 255)
		{
			return false;
		}
		
		return true;
	}

}
