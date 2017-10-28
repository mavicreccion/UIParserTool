package data_readers;

public abstract class DataReader {
	
	protected String outputString;
	protected String filename;
	
	public DataReader(String filename) {
		this.filename = filename;
	}
	
	public String getOutputString() {
		return this.outputString;
	}
	
	public abstract void read();

}
