package Strings;

import java.util.ArrayList;
import java.util.List;

public class LC271_EncodeDecodeListOfStrings {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("nithin");
		list.add("kumar");
		list.add("reddy");
		list.add("bandaru");
		
		String encodedStr = encode(list);
		System.out.println(encodedStr);
		
		List<String> decodeStr = decode(encodedStr);
		System.out.println(decodeStr);
 	}

	private static List<String> decode(String encodedStr) {

		List<String> list = new ArrayList<String>();
		
		int i = 0 ;
		
		while(i < encodedStr.length())
		{
			int slashIndex = encodedStr.indexOf('/' , i);
			int sizeOfStr = Integer.valueOf(encodedStr.substring(i, slashIndex));
			list.add(encodedStr.substring(slashIndex+1 , slashIndex + sizeOfStr + 1));
			i = slashIndex + sizeOfStr + 1;
		}
		
		return list;
	}

	private static String encode(List<String> list) {

		StringBuilder buff = new StringBuilder();
		
		for(String s : list)
		{
			buff.append(s.length()).append('/').append(s);
		}
		
		return buff.toString();
	}

}
