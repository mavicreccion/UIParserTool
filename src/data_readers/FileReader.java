package data_readers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader extends DataReader {

	public FileReader(String filename) {
		super(filename);
	}

	@Override
	public void read() {
		InputStream is;
		BufferedReader buf;
		String fileAsString = "";
		try {
			is = new FileInputStream(this.filename);
			buf = new BufferedReader(new InputStreamReader(is)); 
			
			String line = buf.readLine(); 
			StringBuilder sb = new StringBuilder(); 
			
			while(line != null) { 
				sb.append(line).append("\n"); 
				line = buf.readLine(); 
			} 
			
			fileAsString = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		this.outputString = fileAsString;
				
	}

}
