package ShellScripting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LC195_Print10thLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "‪C:/Users/Nithin Reddy/Desktop/GlassDoor Qs/Groupon.txt";
		
		String line = null;
		
		try 
		{
			FileReader fr = new FileReader(filename);
			
			BufferedReader br = new BufferedReader(fr);
			
			while( (line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
